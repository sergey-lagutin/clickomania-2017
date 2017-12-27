package duel

trait Solver {
  def findSolution(board: Board): Option[List[Move]]
}
