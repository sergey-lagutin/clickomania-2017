package duel

import scala.collection.mutable

case class Move(x: Int, y: Int)

case class Cell(x: Int, y: Int)

case class Component(color: Int) {
  var cells: List[Cell] = Nil

  def size = cells.size
}

class Board(size: Int, array: Array[Array[Int]]) {
  def makeMove(move: Move) : Board = ???

  def hasSolution : Boolean = ???

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
      .filterNot(_.size == 1)
      .map { comp =>
        val cell = comp.cells.head
        Move(cell.x, cell.y)
      }.toList
}
