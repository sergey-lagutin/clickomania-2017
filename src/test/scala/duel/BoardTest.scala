package duel

import org.junit.jupiter.api.Test

class BoardTest {
  @Test def shouldBuildComponent(): Unit = {
    val board = new Board(5,
      Array(
        Array(1, 3, 3, 2, 3),
        Array(1, 2, 3, 0, 4),
        Array(4, 0, 2, 0, 4),
        Array(3, 4, 0, 4, 2),
        Array(2, 3, 3, 0, 0)
      ))
    println(board.components)
    board.components
      .foreach { c => println(c.cells) }

    board.makeMove(Move(4, 4))
  }
}
