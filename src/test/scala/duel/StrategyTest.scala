package duel

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

object StrategyTest {

  def strategies: Array[AnyRef] =
    Array(
      Array(byMaxX, "byMaxX"),
      Array(byMaxXMinY, "byMaxXMinY"),
      Array(byMaxXMaxY, "byMaxXMaxY"),
      Array(byX, "byX"),
      Array(byXSizeReverse, "byXSizeReverse"),
      Array(byYReverse, "byYReverse"),
      Array(byMaxXDistance, "byMaxXDistance"),
      Array(custom, "custom"),
      Array(minimizeOneCellComponent, "minimizeOneCellComponent"),
      Array(minimizeComponentCount, "minimizeComponentCount"),
      Array(minimizeComponentCount2, "minimizeComponentCount2"),
    )

  private def reverseInt = Ordering.Int.reverse

  private def byMaxX: DfsStrategy = (board: Board, cs: Seq[Component]) => cs.sortBy(_.maxX)

  private def byMaxXMinY: DfsStrategy = (board: Board, cs: Seq[Component]) =>
    cs.sortBy(c => (c.maxX, c.minY))

  private def byMaxXMaxY: DfsStrategy = (board: Board, cs: Seq[Component]) =>
    cs.sortBy(c => (c.maxX, c.maxY))

  private def byX: DfsStrategy = (board: Board, cs: Seq[Component]) => cs.sortBy(_.x)

  private def byXSizeReverse: DfsStrategy = (board: Board, cs: Seq[Component]) =>
    cs.sortBy(c => (c.x, c.cellCount))(Ordering.Tuple2(Ordering.Int, reverseInt))

  private def byYReverse: DfsStrategy = (board: Board, cs: Seq[Component]) => cs.sortBy(_.y)(reverseInt)

  private def byMaxXDistance: DfsStrategy = (board: Board, cs: Seq[Component]) =>
    cs.sortBy(c => (c.maxX, c.distanceToZero))(Ordering.Tuple2(Ordering.Int, Ordering.Int))

  private def sameColor(color: Int): Ordering[Component] =
    (x: Component, y: Component) =>
      if (x.color == color) -1
      else if (y.color == color) 1
      else 0

  private def oneCellComponentCountAfterMove(b: Board)(c: Component): Int = {
    val cell = c.cells.head
    val move = Move(cell.x, cell.y)
    b.makeMove(move).components.count(_.cellCount == 1)
  }

  private def minimizeOneCellComponent: DfsStrategy = (board: Board, cs: Seq[Component]) =>
    cs.sortBy(oneCellComponentCountAfterMove(board))

  private def custom: DfsStrategy = (board: Board, cs: Seq[Component]) => {
    val completedColor = cs
      .groupBy(_.color)
      .toList
      .find {
        case (_, components) => components.forall(_.cellCount > 1)
      }

    completedColor match {
      case Some((color, _)) =>
        byMaxXDistance(board,
          cs.sorted(sameColor(color).reverse))
      case None => byMaxXDistance(board, cs)
    }
  }

  private def minimizeComponentCount: DfsStrategy = (board: Board, cs: Seq[Component]) => {
    def componentCountAfterMove(b: Board)(c: Component): Int = {
      val cell = c.cells.head
      val move = Move(cell.x, cell.y)
      b.makeMove(move).components.size
    }

    cs.sortBy(componentCountAfterMove(board))
  }

  private def minimizeComponentCount2: DfsStrategy = (board: Board, cs: Seq[Component]) => {
    def componentCountAfterMove(b: Board)(c: Component): Int = {
      val cell = c.cells.head
      val move = Move(cell.x, cell.y)
      val newBoard = b.makeMove(move)
      if (!newBoard.hasSolution) Int.MaxValue
      else if (newBoard.isSolved) Int.MinValue
      else {
        val possibleMoves =
          scala.util.Random.shuffle(newBoard.componentsToClick)
            .map { comp =>
              val cell = comp.cells.head
              Move(cell.x, cell.y)
            }

        if (possibleMoves.isEmpty) Int.MaxValue
        else
          possibleMoves
            .map(m => newBoard.makeMove(m).components.size)
            .min
      }
    }

    cs.sortBy(componentCountAfterMove(board))
  }
}

class StrategyTest {
  private def solver(strategy: DfsStrategy) = new DfsSolver(strategy, printSolveInfo = false)

  @MethodSource(Array("strategies"))
  @ParameterizedTest
  def testFive(strategy: DfsStrategy, name: String): Unit = {
    val boards = Boards.five.map(array => new Board(5, array))
    estimate(10, boards, name, solver(strategy))
  }

  private def estimate(testAmount: Int, boards: Seq[Board], name: String, solver: Solver): Unit = {
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

  @Test
  def manhattanSolverShouldWork(): Unit = {
    val boards = Boards.five.map(array => new Board(5, array))
    estimate(10, boards, "manhattan", new ManhattanSolver)
  }
}
