package duel

import org.junit.jupiter.api.Test

class SolverTest {
  private val solver = new Solver

  @Test def shouldBuildComponent(): Unit = {
    val board = new Board(5,
      Array(
        Array(1, 0, 0, 2, 0),
        Array(1, 1, 4, 3, 3),
        Array(4, 3, 0, 1, 4),
        Array(1, 4, 0, 3, 3),
        Array(0, 1, 1, 2, 0)
      ))

    val start = System.currentTimeMillis()
    val solution = solver.findSolution(board)
    val end = System.currentTimeMillis()
    println(solution)
    println(end - start + " ms")
  }

  @Test def shouldSolve(): Unit = {
    val board = new Board(5,
      Array(
        Array(1, 0, 0, 2, 0),
        Array(1, 1, 4, 3, 3),
        Array(4, 3, 0, 1, 4),
        Array(1, 4, 0, 3, 3),
        Array(0, 1, 1, 2, 0)
      ))

    val moves = List(Move(3,4), Move(3,3), Move(4,1), Move(2,4), Move(2,3), Move(2,2), Move(1,4), Move(2,2), Move(1,3), Move(0,1), Move(0,0)).reverse
    val result = moves.foldLeft(board)(_ makeMove _)
    println(result)
  }
}