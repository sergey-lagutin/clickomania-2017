package duel

object DfsStrategy {
  def apply(name: String, strategy: (Board, Seq[Component]) => Seq[Component]): DfsStrategy =
    (board: Board, components: Seq[Component]) => strategy(board, components)
}

trait DfsStrategy extends ((Board, Seq[Component]) => Seq[Component])
