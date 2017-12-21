package duel

class Worker {
  private val provider = new TaskProvider()
  private val solver = new Solver()
  private val start = System.currentTimeMillis()
  private var points: Int = 0

  def doTask(): Unit = {
    val board = provider.get(5)
    println(board)
    solver.findSolution(board) match {
      case Some(moves) =>
        provider.submit(moves.reverse) match {
          case Left(error) => println(error)
          case Right(score) => points += score
        }
      case None => throw new RuntimeException
    }
    val now = System.currentTimeMillis()
    val speed = 60 * points.toDouble / ((now - start) / 1000)
    println(speed.toInt + " points/min")
  }
}
