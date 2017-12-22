package duel

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

object StrategyTest {

  trait Strategy extends (Seq[Component] => Seq[Component])

  def strategies: Array[Strategy] =
    Array(
      doNothing
    )

  def doNothing: Strategy = (cs: Seq[Component]) => cs
}

class StrategyTest {
  private val solver = new Solver

  @MethodSource(Array("strategies"))
  @ParameterizedTest
  def testFive(strategy: Seq[Component] => Seq[Component]): Unit = {
    val boards = Boards.five.map(array => new Board(5, array, strategy))
    estimate(boards)
  }

  @MethodSource(Array("strategies"))
  @ParameterizedTest
  def testSix(strategy: Seq[Component] => Seq[Component]): Unit = {
    val boards = Boards.six.take(1).map(array => new Board(6, array, strategy))
    estimate(boards)
  }

  private def estimate(boards: Seq[Board]): Unit = {
    val start = System.currentTimeMillis()
    boards.foreach(solver.findSolution)
    val end = System.currentTimeMillis()
    println(s"time: ${end - start} ms")
  }

}
