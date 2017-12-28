package duel

import scala.annotation.tailrec

class ManhattanSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    val pq = new collection.mutable.PriorityQueue[Solution]()(
      (x: Solution, y: Solution) =>
        if (x.points != y.points)
          x.points - y.points
        else y.componentCount - x.componentCount
    ).reverse

    pq.+=(Solution(board, Nil))

    @tailrec
    def loop(): Option[List[Move]] = {
      val current = pq.dequeue()
      val path = current.path
      val currentBoard = current.board
      println(s"${current.points} ${current.componentCount}")
      println(currentBoard)
      if (currentBoard.isSolved) Some(path)
      else {
        pq ++= currentBoard.possibleMoves
          .map(move => Solution(currentBoard.makeMove(move), move :: path))
          .filter(_.board.hasSolution)
        loop()
      }
    }

    loop()
  }

  case class Solution(board: Board, path: List[Move]) {
    val points: Int = board.manhattan
    val componentCount: Int = board.components.size
  }

}
