package duel

class Solver {
  def findSolution(board: Board): Option[List[Move]] = {
    def loop(current: Board, acc: List[Move]): Option[List[Move]] =
      if (current.isSolved) Some(acc)
      else if (!current.hasSolution) None
      else {
        current.possibleMoves.foldLeft(Option.empty[List[Move]]) { case (acc1, move) =>
          if (acc1.isDefined) acc1
          else {
            val newBoard = current.makeMove(move)
            loop(newBoard, move :: acc)
          }
        }
      }

    loop(board, Nil)
  }

}
