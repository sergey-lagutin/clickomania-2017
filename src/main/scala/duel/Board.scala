package duel

import scala.collection.mutable

case class Move(x: Int, y: Int)

case class Cell(x: Int, y: Int)

case class Component(color: Int, boardSize: Int) {
  var cells: Set[Cell] = Set()

  def cellCount: Int = cells.size

  lazy val minX: Int = cells.map(_.x).min

  lazy val minY: Int = cells.map(_.y).min

  lazy val maxX: Int = cells.map(_.x).max

  lazy val maxY: Int = cells.map(_.y).max

  lazy val x: Int = maxX - minX + 1
  lazy val y: Int = maxY - minY + 1

  private def sqr(i: Int): Int = i * i

  lazy val distanceToZero: Int = sqr(boardSize - maxX - 1) + sqr(minY)
}

class Board(val size: Int, array: Array[Array[Byte]], strategy: (Board, Seq[Component]) => Seq[Component]) {
  def this(size: Int, array: Array[Array[Byte]]) {
    this(size, array, (board, cs) => cs.sortBy(c => (c.maxX, c.maxY)))
  }

  def makeMove(move: Move): Board = {

    val newArray = copy()

    val cell = Cell(move.x, move.y)
    val component = components.find(_.cells.contains(cell)).get
    component.cells.foreach { cell =>
      newArray(cell.x).update(cell.y, -1)
    }

    compact(newArray)

    new Board(size, newArray.map(_.toArray), strategy)
  }

  def rawData: Array[Array[Byte]] = copy()

  private def copy(): Array[Array[Byte]] = {
    val a = Array.fill(size, size)(-1.toByte)
    for {
      x <- array.indices
      y <- array.indices
    } a(x).update(y, array(x)(y))
    a
  }

  private def compact(array: Array[Array[Byte]]): Array[Array[Byte]] = {
    for {
      n <- 0 until size
      x <- array.indices
      row = array(x)
      y <- (0 until size - 1).reverse
    } {
      if (row(y) != -1 && row(y + 1) == -1) {
        row.update(y + 1, row(y))
        row.update(y, -1)
      }
    }

    for {
      n <- 0 until size
      x <- 1 until size
      row = array(x)
      prevRow = array(x - 1)
      if prevRow.forall(_ == -1)
    } {
      array.update(x - 1, row)
      array.update(x, prevRow)
    }

    array
  }

  private def arrayToString(array: Array[Array[Byte]]): String =
    array
      .map(_
        .map(e => if (e >= 0) " " + e else e.toString)
        .mkString(start = "|", sep = "", end = "|"))
      .mkString("\n")

  override def toString: String =
    arrayToString(array)

  def hasSolution: Boolean =
    components
      .groupBy(_.color)
      .toList
      .map(_._2.toList)
      .forall { list =>
        list.size > 1 || list.head.cellCount > 1
      }

  private val cells = new mutable.HashSet[Cell]()

  private def inRange(fromIncl: Int, toExcl: Int)(i: Int): Boolean =
    fromIncl <= i && i < toExcl

  private def inBoard(cell: Cell): Boolean =
    inRange(0, size)(cell.x) && inRange(0, size)(cell.y)


  private def buildComponent(component: Component, cell: Cell): Unit = {
    def sameColor(that: Cell): Boolean =
      array(cell.x)(cell.y) == array(that.x)(that.y)

    cells += cell
    component.cells += cell
    List((-1, 0), (1, 0), (0, -1), (0, 1))
      .map {
        case (dx, dy) => Cell(cell.x + dx, cell.y + dy)
      }.filter(inBoard)
      .filterNot(cells)
      .filter(sameColor)
      .foreach(buildComponent(component, _))
  }

  val components =
    for {
      x <- array.indices
      column = array(x)
      y <- column.indices
      cell = Cell(x, y)
      if !cells(cell)
    } yield {
      val component = Component(array(x)(y), size)
      buildComponent(component, cell)
      component
    }

  def isSolved: Boolean =
    components.size == 1 && components.head.color == -1

  def componentsToClick: Seq[Component] = {
    val lockedColors = components
      .groupBy(_.color)
      .filter(pair => pair._2.size == 2 && pair._2.exists(_.cellCount == 1))
      .keySet

    components
      .filterNot(_.color == -1)
      .filterNot(c => lockedColors(c.color))
      .filterNot(_.cellCount == 1)
  }

  lazy val possibleMoves: List[Move] = {
    strategy(this, scala.util.Random.shuffle(componentsToClick))
      .map { comp =>
        val cell = comp.cells.head
        Move(cell.x, cell.y)
      }.toList
  }

  private def distanceToSameColor(component: Component): Int = {
    def sqr(i: Int) = i * i

    def distanceTo(cell: Cell)(that: Cell): Int =
      5 * (cell.x - that.x).abs + 2 * (cell.y - that.y).abs

    val cell = component.cells.head
    components
      .filter(_.color == component.color)
      .flatMap(_.cells)
      .filterNot(_ == cell)
      .map(distanceTo(cell)).min
  }

  lazy val manhattan: Int = {
    components
      .filter(_.cellCount == 1)
      .map(distanceToSameColor)
      .sum +
      components.count(_.cellCount * 2 > size)
  }
}
