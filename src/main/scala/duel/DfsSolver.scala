package duel

class DfsSolver(printSolveInfo: Boolean = true) {
  def findSolution(board: Board): Option[List[Move]] = {
    var counter = 0

    def loop(current: Board, acc: List[Move]): Option[List[Move]] = {
      counter += 1
      if (current.isSolved) {
        if (printSolveInfo) {
          println(s"success $counter")
          printPath(board, acc.reverse)
        }
        Some(acc)
      }
      else if (!current.hasSolution) {
        if (printSolveInfo) {
          println(s"failed $counter")
          printPath(board, acc.reverse)
        }
        None
      }
      else {
        current.possibleMoves.foldLeft(Option.empty[List[Move]]) { case (acc1, move) =>
          if (acc1.isDefined) acc1
          else {
            val newBoard = current.makeMove(move)
            loop(newBoard, move :: acc)
          }
        }
      }
    }

    loop(board, Nil)
  }

  private def printPath(board: Board, moves: List[Move]): Unit = {
    val boards = moves.foldLeft(List(board)) {
      case (acc, m) => acc.head.makeMove(m) :: acc
    }.reverse

    for {
      i <- 0 until board.size
    } println(boards.map(
      _.rawData(i)
        .map(e => if (e >= 0) " " + e else e.toString)
        .mkString(start = "|", sep = "", end = "|"))
      .mkString("\t"))

    println()
  }
}
