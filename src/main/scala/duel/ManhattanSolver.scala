package duel

import java.util

import scala.annotation.tailrec

class ManhattanSolver extends Solver {
  override def findSolution(board: Board): Option[List[Move]] = {
    val visited = collection.mutable.HashSet.empty[Solution]

    val ordering: Ordering[Solution] = (x: Solution, y: Solution) =>
      if (x.points != y.points)
        x.points - y.points
      else x.componentCount - y.componentCount
    val pq = new collection.mutable.PriorityQueue[Solution]()(ordering).reverse

    pq.+=(Solution(board, Nil))

    def compactQueue(): Unit = {
      val componentCount = board.components.size
      val limit = componentCount * board.size
      if (pq.size > limit) {
        println("compact")
        val elements = pq.dequeueAll
        val newElements = elements.sorted(ordering).take(limit / 2)
        pq ++= newElements
      }
    }

    @tailrec
    def loop(): Option[List[Move]] = {
      compactQueue()
      val current = pq.dequeue()
      val path = current.path
      val currentBoard = current.board
      println(s"${current.points} ${current.componentCount} ${pq.size}")
      if (currentBoard.isSolved) Some(path)
      else {
        val possibleSolutions = currentBoard.possibleMoves
          .map(move => Solution(currentBoard.makeMove(move), move :: path))
          .filter(_.board.hasSolution)
        val newSolutions = possibleSolutions
          .filterNot(visited)

        visited ++= newSolutions
        pq ++= newSolutions
        loop()
      }
    }

    loop()
  }

  case class Solution(board: Board, path: List[Move]) {
    val points: Int = board.manhattan
    val componentCount: Int = board.components.size
    private val array = board.rawData

    override def equals(obj: scala.Any): Boolean =
      if (obj.getClass != this.getClass) false
      else {
        val that = obj.asInstanceOf[Solution]
        util.Arrays.deepEquals(
          this.array.asInstanceOf[Array[AnyRef]],
          that.array.asInstanceOf[Array[AnyRef]])
      }
  }

}
