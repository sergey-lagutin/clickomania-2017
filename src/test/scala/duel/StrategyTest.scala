package duel

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

object StrategyTest {

  trait Strategy extends (Seq[Component] => Seq[Component])

  def strategies: Array[AnyRef] =
    Array(
      Array(doNothing, "doNothing"),
      Array(byColor, "byColor"),
      Array(byColorReverse, "byColorReverse"),
      Array(byMinX, "byMinX"),
      Array(byMinXReverse, "byMinXReverse"),
      Array(byMaxX, "byMaxX"),
      Array(byMaxXReverse, "byMaxXReverse"),
      Array(byMinY, "byMinY"),
      Array(byMinYReverse, "byMinYReverse"),
      Array(byMaxY, "byMaxY"),
      Array(byMaxYReverse, "byMaxYReverse"),
      Array(byMinYMaxX, "byMinYMaxX"),
      Array(byMaxXMinY, "byMaxXMinY"),
      Array(byX, "byX"),
      Array(byXReverse, "byXReverse"),
      Array(byY, "byY"),
      Array(byYReverse, "byYReverse")
    )

  private def doNothing: Strategy = (cs: Seq[Component]) => cs

  private def byColor: Strategy = (cs: Seq[Component]) =>
    cs.sorted(colorOrdering(cs))

  private def colorOrdering(cs: Seq[Component]): Ordering[Component] = {
    val colorMap = cs.groupBy(_.color).mapValues(_.size)
    (x: Component, y: Component) => colorMap(x.color) - colorMap(y.color)
  }

  private def byColorReverse: Strategy = (cs: Seq[Component]) =>
    cs.sorted(colorOrdering(cs).reverse)

  private def byMinX: Strategy = (cs: Seq[Component]) => cs.sortBy(_.minX)

  private def reverseInt = Ordering.Int.reverse

  private def byMinXReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.minX)(reverseInt)

  private def byMaxX: Strategy = (cs: Seq[Component]) => cs.sortBy(_.maxX)

  private def byMaxXReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.maxX)(reverseInt)

  private def byMinY: Strategy = (cs: Seq[Component]) => cs.sortBy(_.minY)

  private def byMinYReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.minY)(reverseInt)

  private def byMaxY: Strategy = (cs: Seq[Component]) => cs.sortBy(_.maxY)

  private def byMaxYReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.maxY)(reverseInt)

  private def byMinYMaxX: Strategy = (cs: Seq[Component]) =>
    cs.sortBy(c => (c.minY, c.maxX))

  private def byMaxXMinY: Strategy = (cs: Seq[Component]) =>
    cs.sortBy(c => (c.maxX, c.minY))

  private def byX: Strategy = (cs: Seq[Component]) => cs.sortBy(_.x)

  private def byXReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.x)(reverseInt)

  private def byY: Strategy = (cs: Seq[Component]) => cs.sortBy(_.y)

  private def byYReverse: Strategy = (cs: Seq[Component]) => cs.sortBy(_.y)(reverseInt)
}

class StrategyTest {
  private val solver = new Solver

  @MethodSource(Array("strategies"))
  @ParameterizedTest
  def testFive(strategy: Seq[Component] => Seq[Component], name: String): Unit = {
    val boards = Boards.five.map(array => new Board(5, array, strategy))
    estimate(10, boards, name)
  }

  @MethodSource(Array("strategies"))
  @ParameterizedTest
  @Disabled
  def testSix(strategy: Seq[Component] => Seq[Component], name: String): Unit = {
    val boards = Boards.six.take(1).map(array => new Board(6, array, strategy))
    estimate(10, boards, name)
  }

  private def estimate(testAmount: Int, boards: Seq[Board], name: String): Unit = {
    var min = Long.MaxValue
    var max = Long.MinValue
    var total = 0L

    for {
      _ <- 1 to testAmount
    } {
      val start = System.currentTimeMillis()
      boards.foreach(solver.findSolution)
      val end = System.currentTimeMillis()
      val time = end - start
      if (time < min) min = time
      if (time > max) max = time
      total += time
    }
    println(s"$name avg: ${total / testAmount}; min: $min; max: $max ms")
  }

}
