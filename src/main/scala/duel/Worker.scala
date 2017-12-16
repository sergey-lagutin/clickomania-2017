package duel

class Worker {
  private val provider = new TaskProvider()
  private val solver = new Solver()

  def doTask(): Unit = {
    val board = provider.get(5)
    solver.findSolution(board) match {
      case None => throw new RuntimeException()
      case Some(moves) => provider.submit(moves)
    }
  }
}
