package duel

class BfsSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    def loop(current: Board, acc: List[Move], visited: Set[Board]): Option[List[Move]] =
      if (current.isSolved) Some(acc)
      else if (!current.hasSolution) None
      else {
        val newBoards = (for {
          move <- current.possibleMoves
          newBoard = current.makeMove(move)
        } yield (newBoard, move :: acc)).toStream

        val newVisited = visited ++ newBoards.map(_._1)
        newBoards.map { case (newBoard, moves) =>
          loop(newBoard, moves, newVisited)
        }.find(_.isDefined)
          .flatten
      }

    loop(board, Nil, Set(board))
  }
}
