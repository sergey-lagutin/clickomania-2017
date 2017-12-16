package duel

import java.util

import scala.collection.mutable

case class Move(x: Int, y: Int)

case class Cell(x: Int, y: Int)

case class Component(color: Int) {
  var cells: List[Cell] = Nil

  def cellCount: Int = cells.size
}

class Board(size: Int, array: Array[Array[Int]]) {
  def makeMove(move: Move): Board = {
    val newArray = new Array[Array[Int]](size)
    array.copyToArray(newArray)

    val cell = Cell(move.x, move.y)
    val component = components.find(_.cells.contains(cell)).get
    component.cells.foreach { cell =>
      newArray(cell.x).update(cell.y, -1)
    }
    print(newArray)

    compact(newArray)

    print(newArray)

    new Board(size, newArray)
  }

  private def compact(array: Array[Array[Int]]): Array[Array[Int]] = {
    for {
      x <- array.indices
      n <- 0 until size
      row = array(x)
      y <- (0 until size - 1).reverse
    } {
      if (row(y) != -1 && row(y + 1) == -1) {
        row.update(y + 1, row(y))
        row.update(y, -1)
      }
    }

    for {
      x <- (0 until size - 1).reverse
      row = array(x)
      nextRow = array(x + 1)
      if row.forall(_ == -1)
    } {
      array.update(x + 1, row)
      array.update(x, nextRow)
    }

    array
  }

  private def print(array: Array[Array[Int]]): Unit =
    println(util.Arrays.deepToString(array.asInstanceOf[Array[AnyRef]]))

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
    component.cells = cell :: component.cells
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
      val component = Component(array(x)(y))
      buildComponent(component, cell)
      component
    }

  def isSolved: Boolean =
    components.size == 1 && components.head.color == -1

  def possibleMoves: List[Move] =
    components
      .filterNot(_.color == -1)
      .filterNot(_.cellCount == 1)
      .map { comp =>
        val cell = comp.cells.head
        Move(cell.x, cell.y)
      }.toList
}
