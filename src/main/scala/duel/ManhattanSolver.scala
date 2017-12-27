package duel

import scala.annotation.tailrec

class ManhattanSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    val pq = new collection.mutable.PriorityQueue[Solution]()(
      (x: Solution, y: Solution) => x.board.manhattan - y.board.manhattan)
      .reverse
    pq.+=(Solution(board, Nil))

    @tailrec
    def loop(): Option[List[Move]] = {
      val current = pq.dequeue()
      val path = current.path
      val currentBoard = current.board
      if (currentBoard.isSolved) Some(path)
      else {
        pq ++= currentBoard.possibleMoves
          .map(move => Solution(currentBoard.makeMove(move), move :: path))
        loop()
      }
    }

    loop()
  }

  case class Solution(board: Board, path: List[Move])

}
