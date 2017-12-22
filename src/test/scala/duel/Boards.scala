package duel

object Boards {
  val five = List(
    Array(Array(2, 1, 1, 2, 2), Array(4, 4, 3, 3, 3), Array(2, 0, 4, 2, 1), Array(4, 4, 0, 4, 2), Array(1, 1, 1, 4, 2)),
    Array(Array(0, 1, 4, 4, 0), Array(0, 1, 0, 4, 3), Array(1, 3, 1, 1, 1), Array(1, 2, 4, 4, 2), Array(3, 2, 3, 1, 2)),
    Array(Array(2, 2, 3, 2, 3), Array(3, 2, 2, 4, 4), Array(0, 1, 1, 0, 1), Array(2, 3, 3, 3, 2), Array(4, 4, 4, 0, 1)),
    Array(Array(2, 0, 1, 3, 1), Array(2, 2, 0, 3, 1), Array(2, 2, 3, 1, 3), Array(0, 0, 0, 1, 3), Array(4, 2, 2, 4, 2)),
    Array(Array(2, 3, 3, 2, 3), Array(1, 1, 0, 4, 4), Array(4, 4, 4, 2, 1), Array(0, 0, 2, 2, 1), Array(3, 2, 3, 0, 0)),
    Array(Array(4, 1, 1, 3, 3), Array(4, 2, 0, 0, 1), Array(3, 2, 3, 0, 1), Array(0, 0, 0, 3, 3), Array(1, 1, 2, 2, 2)),
    Array(Array(0, 0, 0, 2, 2), Array(2, 2, 2, 0, 0), Array(3, 3, 4, 2, 0), Array(4, 4, 3, 4, 2), Array(4, 2, 2, 4, 2)),
    Array(Array(3, 0, 1, 1, 0), Array(4, 4, 3, 3, 2), Array(1, 1, 1, 3, 2), Array(4, 2, 3, 2, 0), Array(4, 3, 4, 3, 4)),
    Array(Array(4, 3, 2, 2, 0), Array(4, 1, 4, 2, 0), Array(0, 0, 2, 4, 1), Array(3, 2, 0, 2, 3), Array(3, 3, 4, 4, 4)),
    Array(Array(1, 4, 1, 3, 3), Array(2, 2, 1, 4, 1), Array(1, 0, 0, 2, 2), Array(3, 3, 1, 3, 3), Array(0, 1, 1, 0, 3)),
    Array(Array(0, 2, 0, 2, 0), Array(0, 1, 1, 2, 4), Array(4, 3, 0, 0, 3), Array(1, 0, 4, 2, 4), Array(1, 1, 3, 4, 3)),
    Array(Array(2, 2, 4, 3, 0), Array(2, 1, 1, 3, 0), Array(2, 4, 2, 2, 0), Array(2, 2, 1, 1, 3), Array(3, 0, 0, 2, 2)),
    Array(Array(4, 4, 2, 3, 3), Array(3, 4, 0, 0, 0), Array(1, 3, 3, 2, 4), Array(0, 1, 1, 0, 4), Array(3, 3, 0, 1, 1)),
    Array(Array(3, 3, 3, 0, 3), Array(2, 2, 1, 0, 1), Array(0, 0, 2, 1, 3), Array(2, 0, 4, 4, 2), Array(1, 1, 3, 0, 0)),
    Array(Array(4, 2, 2, 1, 0), Array(3, 3, 4, 4, 4), Array(4, 2, 1, 1, 0), Array(2, 0, 1, 2, 2), Array(2, 2, 1, 1, 2)),
    Array(Array(0, 2, 2, 0, 1), Array(0, 1, 2, 1, 2), Array(3, 3, 3, 3, 2), Array(2, 4, 1, 2, 1), Array(4, 1, 1, 2, 1)),
    Array(Array(3, 4, 4, 4, 0), Array(0, 0, 2, 3, 0), Array(4, 4, 1, 1, 0), Array(3, 3, 3, 2, 3), Array(4, 4, 1, 1, 1)),
    Array(Array(4, 4, 1, 1, 0), Array(1, 4, 4, 3, 3), Array(0, 1, 2, 2, 0), Array(0, 3, 3, 4, 4), Array(0, 0, 1, 0, 4)),
    Array(Array(4, 4, 0, 0, 1), Array(2, 1, 1, 4, 1), Array(4, 4, 2, 1, 4), Array(0, 3, 3, 0, 4), Array(1, 1, 4, 1, 1)),
    Array(Array(4, 2, 3, 3, 2), Array(0, 0, 0, 4, 4), Array(4, 2, 4, 3, 2), Array(4, 4, 0, 0, 1), Array(0, 2, 2, 2, 1)),
    Array(Array(0, 4, 2, 1, 1), Array(0, 2, 2, 4, 2), Array(0, 1, 2, 1, 3), Array(3, 1, 1, 2, 2), Array(1, 3, 3, 0, 1)),
    Array(Array(1, 1, 3, 1, 1), Array(0, 4, 4, 4, 3), Array(1, 1, 0, 1, 2), Array(2, 2, 3, 1, 0), Array(0, 3, 0, 2, 2)),
    Array(Array(2, 2, 0, 4, 1), Array(3, 3, 1, 0, 0), Array(3, 3, 2, 3, 2), Array(4, 2, 1, 1, 2), Array(2, 2, 1, 2, 0)),
    Array(Array(0, 4, 4, 2, 3), Array(4, 0, 3, 1, 4), Array(4, 0, 3, 1, 4), Array(0, 4, 1, 2, 3), Array(3, 3, 1, 2, 3)),
    Array(Array(4, 1, 0, 1, 4), Array(4, 0, 1, 0, 4), Array(2, 2, 3, 0, 4), Array(4, 0, 2, 2, 2), Array(0, 0, 0, 4, 3)),
    Array(Array(3, 2, 1, 1, 3), Array(2, 2, 1, 3, 1), Array(4, 0, 0, 0, 2), Array(1, 2, 4, 4, 2), Array(0, 0, 1, 3, 3)),
    Array(Array(1, 3, 1, 0, 0), Array(3, 3, 1, 2, 1), Array(0, 0, 0, 4, 0), Array(3, 3, 4, 0, 0), Array(0, 0, 0, 2, 1)),
    Array(Array(0, 1, 0, 4, 4), Array(0, 3, 3, 1, 0), Array(2, 3, 2, 4, 0), Array(0, 0, 2, 4, 2), Array(0, 0, 3, 3, 2)),
    Array(Array(3, 4, 4, 0, 0), Array(2, 3, 3, 2, 3), Array(4, 4, 4, 3, 2), Array(3, 3, 2, 3, 2), Array(0, 0, 1, 1, 3)),
    Array(Array(2, 2, 3, 2, 4), Array(3, 1, 1, 2, 4), Array(2, 3, 3, 3, 1), Array(4, 0, 4, 1, 1), Array(0, 0, 4, 2, 2)),
    Array(Array(2, 4, 4, 4, 3), Array(1, 1, 2, 2, 3), Array(2, 3, 3, 1, 2), Array(4, 4, 2, 1, 0), Array(3, 3, 1, 0, 0)),
    Array(Array(0, 0, 3, 3, 1), Array(4, 2, 2, 4, 1), Array(2, 3, 4, 2, 1), Array(1, 1, 4, 2, 3), Array(0, 2, 2, 0, 4)),
    Array(Array(3, 3, 3, 0, 0), Array(4, 0, 0, 4, 2), Array(4, 4, 1, 2, 2), Array(1, 4, 1, 3, 3), Array(4, 4, 2, 2, 3)),
    Array(Array(4, 0, 0, 1, 4), Array(3, 3, 3, 2, 4), Array(4, 1, 0, 3, 2), Array(0, 2, 2, 3, 0), Array(0, 4, 0, 3, 4)),
    Array(Array(0, 0, 1, 1, 4), Array(1, 4, 4, 1, 0), Array(0, 2, 2, 3, 3), Array(1, 2, 0, 2, 4), Array(2, 3, 3, 0, 4)),
    Array(Array(3, 1, 1, 2, 1), Array(0, 3, 2, 1, 3), Array(0, 3, 0, 1, 3), Array(3, 0, 4, 1, 0), Array(4, 1, 2, 2, 0)),
    Array(Array(3, 1, 1, 1, 2), Array(0, 0, 0, 4, 4), Array(2, 2, 3, 2, 2), Array(3, 2, 3, 4, 3), Array(0, 0, 0, 4, 4)),
    Array(Array(0, 1, 1, 1, 0), Array(1, 3, 3, 2, 0), Array(2, 2, 1, 2, 1), Array(3, 0, 1, 4, 0), Array(3, 0, 1, 4, 0)),
    Array(Array(4, 3, 3, 2, 2), Array(4, 3, 3, 0, 0), Array(1, 2, 2, 3, 3), Array(1, 1, 4, 4, 0), Array(1, 4, 1, 1, 0)),
    Array(Array(0, 3, 4, 0, 0), Array(4, 4, 1, 1, 0), Array(0, 3, 4, 3, 2), Array(3, 1, 3, 1, 3), Array(3, 3, 2, 3, 3)),
    Array(Array(0, 0, 2, 0, 4), Array(0, 2, 0, 0, 3), Array(4, 0, 3, 3, 1), Array(2, 0, 1, 0, 3), Array(2, 3, 3, 0, 0)),
    Array(Array(4, 4, 1, 4, 0), Array(2, 2, 2, 4, 0), Array(2, 1, 0, 1, 0), Array(2, 0, 0, 2, 1), Array(4, 4, 1, 4, 4)),
    Array(Array(0, 2, 2, 2, 0), Array(0, 3, 3, 4, 4), Array(1, 3, 3, 2, 2), Array(4, 1, 3, 4, 2), Array(0, 0, 0, 3, 3)),
    Array(Array(2, 1, 1, 4, 1), Array(4, 4, 1, 2, 4), Array(4, 1, 0, 2, 4), Array(3, 4, 3, 0, 4), Array(2, 4, 1, 1, 3)),
    Array(Array(1, 2, 2, 2, 1), Array(2, 4, 0, 0, 4), Array(2, 0, 2, 4, 2), Array(0, 0, 1, 1, 4), Array(3, 3, 3, 2, 4)),
    Array(Array(4, 2, 2, 2, 4), Array(4, 4, 0, 0, 2), Array(4, 2, 3, 3, 0), Array(1, 4, 4, 1, 0), Array(2, 3, 3, 2, 2)),
    Array(Array(2, 3, 3, 2, 0), Array(2, 2, 1, 1, 0), Array(1, 1, 3, 3, 2), Array(3, 4, 3, 4, 2), Array(3, 1, 0, 0, 1)),
    Array(Array(0, 3, 2, 3, 4), Array(1, 0, 0, 0, 1), Array(3, 3, 1, 3, 4), Array(0, 2, 2, 2, 0), Array(1, 1, 0, 1, 2)),
    Array(Array(2, 2, 1, 1, 0), Array(2, 3, 0, 1, 0), Array(1, 1, 3, 2, 1), Array(1, 4, 4, 2, 3), Array(4, 0, 0, 3, 3)),
    Array(Array(1, 1, 1, 1, 3), Array(2, 2, 0, 2, 3), Array(1, 1, 0, 3, 4), Array(4, 1, 1, 2, 3), Array(4, 1, 2, 2, 3)),
  )

  val six = List(
    Array(Array(1, 3, 1, 1, 4, 0), Array(3, 4, 4, 0, 2, 2), Array(3, 1, 0, 4, 4, 4), Array(2, 2, 0, 0, 0, 2), Array(1, 3, 3, 3, 4, 4), Array(3, 4, 4, 0, 0, 4)),
    Array(Array(4, 2, 3, 3, 3, 2), Array(1, 4, 4, 0, 0, 3), Array(2, 2, 2, 1, 1, 3), Array(4, 0, 4, 4, 0, 2), Array(4, 3, 0, 0, 1, 4), Array(3, 1, 1, 3, 2, 2)),
    Array(Array(2, 2, 2, 3, 0, 4), Array(4, 0, 3, 4, 4, 0), Array(1, 3, 3, 1, 3, 2), Array(3, 0, 2, 0, 0, 4), Array(2, 3, 0, 4, 0, 4), Array(0, 1, 1, 2, 2, 0)),
    Array(Array(0, 3, 3, 3, 0, 3), Array(2, 1, 1, 1, 3, 2), Array(2, 4, 0, 2, 0, 4), Array(4, 0, 3, 3, 2, 1), Array(1, 3, 1, 0, 2, 4), Array(3, 1, 2, 4, 0, 0)),
    Array(Array(4, 4, 0, 0, 4, 3), Array(0, 0, 2, 2, 1, 1), Array(0, 2, 3, 3, 3, 1), Array(3, 2, 4, 4, 0, 3), Array(1, 2, 2, 1, 2, 2), Array(4, 2, 2, 4, 0, 4)),
    Array(Array(0, 0, 0, 2, 3, 2), Array(3, 2, 2, 3, 0, 2), Array(0, 2, 1, 0, 1, 1), Array(0, 1, 2, 2, 4, 0), Array(2, 4, 4, 3, 0, 4), Array(1, 2, 2, 3, 4, 4)),
    Array(Array(3, 4, 4, 4, 3, 1), Array(2, 2, 2, 1, 0, 1), Array(0, 0, 3, 1, 4, 4), Array(3, 0, 4, 4, 2, 2), Array(4, 0, 3, 3, 4, 0), Array(0, 4, 2, 2, 2, 4)),
    Array(Array(4, 2, 2, 4, 2, 3), Array(3, 1, 1, 0, 2, 0), Array(3, 4, 2, 1, 4, 0), Array(3, 2, 4, 1, 4, 4), Array(4, 1, 3, 4, 2, 1), Array(3, 1, 3, 4, 3, 3)),
    Array(Array(3, 1, 1, 1, 3, 4), Array(4, 0, 4, 4, 4, 0), Array(3, 2, 3, 2, 1, 1), Array(3, 0, 0, 2, 3, 1), Array(3, 3, 1, 1, 3, 4), Array(2, 2, 4, 4, 1, 1)),
    Array(Array(4, 3, 4, 1, 0, 0), Array(3, 4, 1, 3, 3, 0), Array(2, 2, 3, 4, 1, 4), Array(4, 4, 3, 0, 1, 0), Array(0, 0, 0, 1, 2, 0), Array(3, 1, 1, 3, 2, 1)),
    Array(Array(0, 2, 0, 3, 1, 4), Array(1, 2, 1, 3, 1, 4), Array(1, 2, 0, 0, 0, 2), Array(0, 2, 1, 2, 4, 3), Array(0, 1, 2, 4, 3, 4), Array(3, 3, 4, 4, 2, 2)),
    Array(Array(3, 0, 4, 3, 2, 1), Array(3, 2, 4, 3, 0, 3), Array(0, 0, 1, 2, 0, 3), Array(1, 4, 4, 3, 3, 4), Array(1, 1, 0, 2, 2, 1), Array(0, 3, 3, 3, 2, 0)),
    Array(Array(4, 4, 1, 1, 4, 4), Array(1, 1, 0, 3, 3, 1), Array(3, 0, 2, 4, 4, 2), Array(3, 1, 1, 0, 4, 2), Array(3, 0, 0, 2, 2, 1), Array(0, 0, 4, 4, 4, 1)),
    Array(Array(2, 4, 4, 3, 2, 4), Array(1, 1, 1, 0, 2, 4), Array(0, 4, 3, 2, 0, 0), Array(3, 4, 1, 0, 2, 2), Array(2, 1, 1, 3, 4, 1), Array(2, 1, 3, 2, 2, 2)),
    Array(Array(3, 2, 3, 0, 2, 2), Array(3, 1, 1, 2, 0, 3), Array(4, 4, 4, 2, 0, 3), Array(3, 0, 1, 4, 4, 1), Array(4, 4, 1, 4, 3, 1), Array(0, 0, 3, 1, 2, 2)),
    Array(Array(1, 3, 1, 3, 0, 0), Array(0, 4, 1, 4, 2, 1), Array(2, 3, 0, 0, 4, 2), Array(2, 3, 2, 4, 4, 2), Array(1, 1, 1, 0, 0, 0), Array(0, 0, 2, 1, 1, 1)),
    Array(Array(0, 0, 2, 3, 2, 4), Array(3, 0, 2, 0, 3, 2), Array(2, 0, 3, 2, 1, 1), Array(0, 3, 2, 3, 2, 4), Array(4, 4, 1, 1, 4, 2), Array(3, 3, 3, 2, 3, 3)),
    Array(Array(4, 4, 4, 0, 2, 0), Array(1, 2, 0, 3, 2, 1), Array(1, 2, 1, 2, 3, 1), Array(2, 1, 4, 1, 3, 2), Array(2, 1, 4, 1, 2, 4), Array(1, 2, 0, 0, 0, 4)),
    Array(Array(3, 1, 0, 1, 1, 3), Array(2, 2, 3, 4, 4, 3), Array(3, 1, 0, 2, 3, 4), Array(1, 1, 2, 2, 1, 4), Array(0, 0, 0, 1, 3, 2), Array(3, 2, 2, 0, 0, 2)),
    Array(Array(4, 1, 2, 2, 3, 3), Array(1, 3, 0, 1, 4, 4), Array(0, 3, 0, 3, 3, 1), Array(4, 1, 4, 2, 2, 4), Array(3, 2, 2, 1, 3, 4), Array(4, 1, 2, 1, 4, 2)),
    Array(Array(3, 3, 3, 4, 4, 2), Array(1, 1, 1, 2, 2, 3), Array(3, 3, 0, 0, 1, 1), Array(4, 4, 3, 4, 4, 3), Array(1, 4, 1, 2, 3, 2), Array(3, 1, 4, 1, 1, 4)),
    Array(Array(1, 1, 1, 4, 4, 2), Array(2, 2, 3, 4, 1, 0), Array(1, 3, 3, 0, 3, 3), Array(3, 2, 2, 0, 2, 2), Array(4, 4, 0, 0, 1, 3), Array(1, 1, 4, 4, 4, 3)),
    Array(Array(2, 0, 0, 2, 1, 2), Array(3, 2, 3, 4, 0, 4), Array(4, 4, 4, 2, 0, 3), Array(1, 0, 1, 2, 4, 1), Array(0, 0, 4, 1, 2, 2), Array(1, 2, 2, 1, 3, 3)),
    Array(Array(2, 4, 4, 1, 3, 3), Array(1, 1, 2, 1, 4, 0), Array(4, 4, 3, 2, 0, 0), Array(1, 1, 2, 0, 3, 4), Array(4, 1, 2, 0, 4, 0), Array(0, 3, 3, 0, 1, 1)),
    Array(Array(3, 3, 0, 2, 2, 1), Array(3, 0, 3, 1, 3, 0), Array(3, 1, 3, 0, 3, 1), Array(1, 4, 4, 3, 0, 1), Array(0, 4, 1, 0, 3, 1), Array(4, 4, 1, 0, 0, 3)),
    Array(Array(1, 1, 4, 2, 0, 3), Array(3, 1, 0, 2, 0, 2), Array(1, 2, 2, 1, 3, 2), Array(0, 0, 0, 2, 2, 4), Array(0, 3, 3, 4, 1, 0), Array(3, 0, 0, 4, 1, 4)),
    Array(Array(2, 2, 1, 1, 0, 0), Array(2, 2, 2, 1, 3, 2), Array(1, 4, 4, 3, 2, 4), Array(1, 3, 3, 2, 2, 4), Array(1, 3, 1, 3, 3, 4), Array(1, 4, 4, 0, 0, 3)),
    Array(Array(0, 4, 4, 4, 0, 3), Array(2, 2, 2, 3, 2, 2), Array(3, 1, 1, 1, 3, 4), Array(2, 3, 3, 1, 4, 4), Array(0, 2, 2, 3, 3, 2), Array(4, 4, 1, 0, 0, 2)),
    Array(Array(3, 3, 0, 0, 2, 2), Array(3, 4, 4, 2, 1, 4), Array(0, 0, 1, 4, 2, 4), Array(0, 2, 1, 2, 1, 2), Array(3, 3, 0, 0, 2, 4), Array(1, 1, 1, 2, 4, 4)),
    Array(Array(0, 0, 1, 3, 1, 4), Array(0, 3, 3, 1, 3, 4), Array(3, 2, 2, 4, 2, 2), Array(1, 0, 3, 3, 1, 0), Array(4, 0, 4, 0, 1, 4), Array(0, 3, 1, 1, 3, 4)),
    Array(Array(2, 3, 3, 2, 3, 4), Array(4, 0, 0, 2, 3, 3), Array(1, 1, 3, 3, 0, 0), Array(3, 0, 0, 4, 2, 2), Array(2, 2, 2, 4, 1, 2), Array(1, 4, 4, 3, 3, 3)),
    Array(Array(1, 1, 1, 0, 0, 2), Array(2, 4, 4, 0, 1, 1), Array(0, 0, 0, 4, 2, 0), Array(3, 1, 4, 0, 1, 0), Array(0, 3, 3, 3, 2, 2), Array(3, 0, 0, 4, 4, 0)),
    Array(Array(0, 1, 0, 1, 1, 2), Array(2, 1, 2, 2, 1, 2), Array(3, 3, 0, 0, 0, 3), Array(0, 0, 1, 1, 3, 0), Array(2, 2, 1, 3, 0, 3), Array(2, 3, 3, 2, 0, 3)),
    Array(Array(1, 2, 2, 3, 3, 2), Array(0, 0, 2, 2, 3, 1), Array(2, 2, 0, 3, 3, 1), Array(2, 4, 4, 2, 1, 2), Array(4, 1, 1, 0, 3, 4), Array(3, 3, 0, 3, 3, 4)),
    Array(Array(2, 0, 0, 1, 4, 4), Array(1, 1, 2, 0, 3, 0), Array(0, 0, 0, 2, 3, 0), Array(2, 1, 4, 2, 0, 3), Array(4, 3, 0, 0, 3, 4), Array(0, 1, 3, 0, 1, 3)),
    Array(Array(1, 3, 1, 3, 3, 3), Array(3, 3, 0, 2, 2, 2), Array(2, 2, 4, 4, 4, 0), Array(4, 4, 3, 1, 3, 2), Array(1, 3, 1, 3, 2, 3), Array(4, 1, 3, 4, 3, 3)),
    Array(Array(2, 2, 3, 3, 2, 3), Array(3, 3, 1, 0, 0, 3), Array(3, 4, 1, 3, 2, 3), Array(4, 2, 0, 3, 4, 2), Array(2, 0, 4, 3, 2, 2), Array(3, 3, 3, 1, 1, 4)),
    Array(Array(2, 0, 4, 4, 1, 4), Array(2, 1, 0, 0, 1, 0), Array(0, 0, 3, 2, 3, 0), Array(2, 2, 1, 2, 1, 4), Array(4, 3, 3, 0, 0, 1), Array(2, 1, 1, 2, 4, 1)),
    Array(Array(3, 0, 0, 4, 3, 2), Array(2, 0, 3, 3, 0, 0), Array(4, 4, 1, 2, 4, 1), Array(3, 1, 1, 0, 0, 3), Array(2, 3, 2, 2, 4, 1), Array(3, 4, 4, 4, 3, 2)),
    Array(Array(4, 4, 1, 1, 2, 3), Array(3, 3, 0, 1, 0, 4), Array(1, 1, 3, 3, 0, 4), Array(3, 3, 4, 2, 3, 2), Array(0, 3, 1, 3, 2, 3), Array(0, 1, 1, 2, 3, 3)),
    Array(Array(2, 1, 1, 3, 2, 1), Array(1, 4, 2, 1, 2, 1), Array(4, 2, 0, 0, 4, 4), Array(2, 4, 3, 1, 1, 4), Array(0, 0, 4, 0, 3, 0), Array(3, 3, 4, 2, 2, 2)),
    Array(Array(2, 2, 2, 0, 0, 4), Array(1, 1, 0, 3, 3, 4), Array(4, 0, 0, 0, 4, 2), Array(1, 2, 4, 2, 3, 3), Array(4, 4, 1, 2, 3, 0), Array(1, 1, 4, 4, 4, 0)),
    Array(Array(0, 2, 2, 3, 0, 4), Array(3, 1, 1, 3, 3, 4), Array(3, 2, 0, 0, 2, 1), Array(4, 0, 2, 3, 3, 0), Array(3, 3, 4, 4, 0, 2), Array(2, 2, 4, 4, 3, 3)),
    Array(Array(4, 1, 1, 0, 0, 3), Array(3, 4, 4, 3, 3, 0), Array(3, 2, 2, 0, 2, 0), Array(4, 4, 4, 1, 2, 3), Array(1, 0, 4, 0, 4, 2), Array(2, 2, 3, 1, 3, 2)),
    Array(Array(3, 4, 1, 1, 3, 4), Array(4, 3, 1, 3, 3, 4), Array(3, 0, 0, 4, 4, 2), Array(2, 1, 1, 3, 3, 0), Array(3, 1, 1, 4, 4, 4), Array(2, 0, 3, 2, 2, 3)),
    Array(Array(3, 3, 4, 0, 4, 3), Array(0, 3, 4, 3, 4, 3), Array(1, 1, 4, 2, 2, 4), Array(3, 0, 1, 1, 0, 0), Array(1, 1, 4, 4, 3, 1), Array(0, 0, 1, 0, 0, 0)),
    Array(Array(3, 3, 2, 2, 0, 3), Array(0, 0, 1, 2, 1, 2), Array(3, 3, 4, 4, 2, 1), Array(3, 3, 4, 0, 0, 3), Array(0, 0, 2, 2, 4, 3), Array(4, 4, 4, 1, 1, 3)),
    Array(Array(4, 4, 0, 0, 2, 2), Array(1, 2, 3, 0, 2, 4), Array(3, 2, 4, 1, 3, 1), Array(2, 1, 4, 3, 3, 1), Array(1, 4, 2, 4, 1, 2), Array(3, 3, 4, 2, 3, 3)),
    Array(Array(3, 3, 2, 3, 3, 0), Array(3, 2, 1, 1, 3, 0), Array(2, 2, 4, 4, 2, 3), Array(1, 0, 0, 0, 2, 1), Array(4, 4, 4, 1, 4, 4), Array(0, 0, 0, 3, 2, 3)),
    Array(Array(1, 1, 1, 0, 0, 4), Array(2, 2, 0, 1, 4, 2), Array(3, 1, 1, 0, 0, 2), Array(4, 4, 2, 2, 4, 3), Array(4, 2, 3, 3, 3, 2), Array(4, 1, 1, 2, 4, 4)),
  )

  def print(size: Int, amount: Int): Unit = {
    val provider = new TaskProvider
    val solver = new Solver
    List.fill(amount) {
      val board = provider.get(size)
      println {
        val array = board.rawData

        array
          .map(_.mkString(start = "Array(", sep = ", ", end = ")"))
          .mkString(start = "Array(", sep = ", ", end = ")")

      }
      solver.findSolution(board) match {
        case Some(moves) =>
          val orderedMoves = moves.reverse
          provider.submit(orderedMoves) match {
            case Left(error) =>
              println(error)
              println(orderedMoves)
              orderedMoves.foldLeft(board) {
                case (b, move) =>
                  println(b)
                  println(move)
                  b.makeMove(move)
              }
            case _ =>
          }
        case None => throw new RuntimeException
      }
    }
  }
}
