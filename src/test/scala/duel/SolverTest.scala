package duel

import org.junit.jupiter.api.Test

class SolverTest {
  private val solver = new Solver

  @Test def shouldBuildComponent(): Unit = {
    val board = new Board(5,
      Array(
        Array(1, 1, 3, 3, 4),
        Array(2, 2, 2, 0, 0),
        Array(0, 0, 0, 1, 4),
        Array(4, 4, 4, 1, 1),
        Array(0, 0, 0, 2, 2)
      ))

    val solution = solver.findSolution(board)
    println(solution)
  }

  @Test def shouldSolve(): Unit = {
    val board = new Board(5,
      Array(
        Array(1, 1, 3, 3, 4),
        Array(2, 2, 2, 0, 0),
        Array(0, 0, 0, 1, 4),
        Array(4, 4, 4, 1, 1),
        Array(0, 0, 0, 2, 2)
      ))

    val moves = List(Move(4,4), Move(4,2), Move(3,4), Move(3,3), Move(2,3), Move(2,4), Move(1,4), Move(1,2), Move(0,3), Move(0,1)).reverse
    val result = moves.foldLeft(board)(_ makeMove _)
    println(result)
  }
}