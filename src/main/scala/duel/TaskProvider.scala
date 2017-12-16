package duel

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization

import scalaj.http.Http

case class Game(width: Int, height: Int, cells: String) {
  val realCells: Array[Array[Int]] =
    for {
      col <- cells.split("\\],")
    } yield col.split("\\D+")
      .filter(_.nonEmpty)
      .map(_.toInt)
}

class TaskProvider {
  private val TOKEN = "QZEXVABGZJVZBRNM"
  private val POST = s"https://clickomania.anadea.info/game/$TOKEN"

  private def getUrl(size: Int): String =
    s"https://clickomania.anadea.info/game?size=$size&token=$TOKEN"

  def get(size: Int): Board = {
    val json = Http(getUrl(size)).asString.body

    implicit val formats = {
      Serialization.formats(FullTypeHints(List(classOf[Game])))
    }

    val game = parse(json).extract[Game]
    new Board(game.width, game.realCells)
  }

  def submit(moves: Seq[Move]): Unit = {
    val data = s"success_moves=[${moves.map(m => s"[${m.x},${m.y}]").mkString(",")}]"
    println(data)
    val response = Http(POST).postData(data).asString
    println(response)
  }
}
