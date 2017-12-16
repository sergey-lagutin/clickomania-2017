package duel

class Solver {
  def findSolution(board: Board): Option[List[Move]] = {
    def loop(current: Board, acc: List[Move]): Option[List[Move]] =
      if (current.isSolved) Some(acc)
      else if (!current.hasSolution) None
      else {
        val newBoards = for {
          move <- current.possibleMoves
          newBoard: Board = board.makeMove(move)
        } yield (newBoard, move :: acc)

        newBoards.map { case (newBoard, moves) =>
          loop(newBoard, moves)
        }
          .filter(_.isDefined)
          .head
      }

    loop(board, Nil)
  }

}
