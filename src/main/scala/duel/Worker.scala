package duel

class Worker {
  private val provider = new TaskProvider()
  private val solver = new ManhattanSolver()
  private val start = System.currentTimeMillis()
  private var points: Int = 0

  def doTask(): Unit = {
    val board = provider.get(31)
    println(board)
    solver.findSolution(board) match {
      case Some(moves) =>
        val orderedMoves = moves.reverse
        provider.submit(orderedMoves) match {
          case Left(error) =>
            println(error)
            println(orderedMoves)
            orderedMoves.foldLeft(board){
              case (b, move) =>
                println(b)
                println(move)
                b.makeMove(move)
            }
          case Right(score) => points += score
        }
      case None => throw new RuntimeException
    }
    val now = System.currentTimeMillis()
    val speed = 60 * points.toDouble / ((now - start) / 1000)
    println(speed.toInt + " points/min")
  }
}
