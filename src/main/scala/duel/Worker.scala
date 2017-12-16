package duel

class Worker {
  private val provider = new TaskProvider()
  private val solver = new Solver()

  def doTask(): Unit = {
    val board = provider.get(5)
    println(board)
    solver.findSolution(board) match {
      case Some(moves) => provider.submit(moves.reverse)
      case None =>
    }
  }
}
