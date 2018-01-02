package duel

object Dfs {

  trait DfsStrategy extends ((Board, Seq[Component]) => Seq[Component])

  class DfsSolver(strategy: DfsStrategy = (board, cs) => cs.sortBy(c => (c.maxX, c.maxY))) extends Solver {
    override def findSolution(board: Board): Option[List[Move]] = {
      def loop(current: Board, acc: List[Move]): Option[List[Move]] = {
        if (current.isSolved)
          Some(acc)
        else if (!current.hasSolution)
          None
        else {
          val components = strategy(current, scala.util.Random.shuffle(current.componentsToClick))
          current.possibleMovesFor(components)
            .foldLeft(Option.empty[List[Move]]) { case (acc1, move) =>
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
  }

}