package duel

import java.util

import scala.annotation.tailrec

class ManhattanSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    val visited = collection.mutable.HashSet.empty[Solution]

    val ordering: Ordering[Solution] = (x: Solution, y: Solution) =>
      if (x.points != y.points)
        x.points - y.points
      else x.componentCount - y.componentCount
    val pq = new collection.mutable.PriorityQueue[Solution]()(ordering).reverse

    pq.+=(Solution(board, Nil))

    @tailrec
    def loop(): Option[List[Move]] = {
      val current = pq.dequeue()
      val path = current.path
      val currentBoard = current.board
      if (currentBoard.isSolved) Some(path)
      else {
        val possibleSolutions = currentBoard.possibleMoves
          .map(move => Solution(currentBoard.makeMove(move), move :: path))
          .filter(_.board.hasSolution)
        val newSolutions = possibleSolutions
          .filterNot(visited)

        visited ++= newSolutions
        pq ++= newSolutions
        loop()
      }
    }

    loop()
  }

  case class Solution(board: Board, path: List[Move]) {
    val points: Int = manhattan
    val componentCount: Int = board.components.size
    private val array = board.rawData

    override def equals(obj: scala.Any): Boolean =
      if (obj.getClass != this.getClass) false
      else {
        val that = obj.asInstanceOf[Solution]
        util.Arrays.deepEquals(
          this.array.asInstanceOf[Array[AnyRef]],
          that.array.asInstanceOf[Array[AnyRef]])
      }

    private def distanceToSameColor(component: Component): Int = {
      def distanceTo(cell: Cell)(that: Cell): Int =
        5 * (cell.x - that.x).abs + 2 * (cell.y - that.y).abs

      val cell = component.cells.head
      board.components
        .filter(_.color == component.color)
        .flatMap(_.cells)
        .filterNot(_ == cell)
        .map(distanceTo(cell)).min
    }

    private def manhattan: Int = {
      board.components
        .filter(_.cellCount == 1)
        .map(distanceToSameColor)
        .sum +
        3 * board.components.count(_.cellCount * 2 > board.size)
    }
  }

}
