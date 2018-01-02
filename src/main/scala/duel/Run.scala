package duel

object Run extends App {
  val worker = new Worker()
  while (true) {
    worker.doTask()
  }
}
