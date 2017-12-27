package duel

import scala.annotation.tailrec

class ManhattanSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    val pq = new collection.mutable.PriorityQueue[Solution]()(
      (x: Solution, y: Solution) => x.points - y.points)
      .reverse
    pq.+=(Solution(board, Nil))

    @tailrec
    def loop(): Option[List[Move]] = {
      val current = pq.dequeue()
      val path = current.path
      val currentBoard = current.board
      println(current.points)
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
  }

}
