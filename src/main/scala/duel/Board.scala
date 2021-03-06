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

class Board(val size: Int, array: Array[Array[Byte]]) {

  def makeMove(move: Move): Board = {

    val newArray = copy()

    val cell = Cell(move.x, move.y)
    val component = components.find(_.cells.contains(cell)).get
    component.cells.foreach { cell =>
      newArray(cell.x).update(cell.y, -1)
    }

    compact(newArray)

    new Board(size, newArray.map(_.toArray))
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

  val components = {
    val cells = new mutable.HashSet[Cell]()

    def inBoard(i: Int): Boolean =
      0 <= i && i < size

    def cellInBoard(cell: Cell): Boolean =
      inBoard(cell.x) && inBoard(cell.y)

    def buildComponent(component: Component, cell: Cell): Unit = {
      def sameColor(that: Cell): Boolean =
        array(cell.x)(cell.y) == array(that.x)(that.y)

      cells += cell
      component.cells += cell
      List((-1, 0), (1, 0), (0, -1), (0, 1))
        .map {
          case (dx, dy) => Cell(cell.x + dx, cell.y + dy)
        }.filter(cellInBoard)
        .filterNot(cells)
        .filter(sameColor)
        .foreach(buildComponent(component, _))
    }

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

  lazy val possibleMoves: List[Move] =
    possibleMovesFor(scala.util.Random.shuffle(componentsToClick))

  def possibleMovesFor(components: Seq[Component]): List[Move] =
    components
      .map { comp =>
        val cell = comp.cells.head
        Move(cell.x, cell.y)
      }.toList
}
