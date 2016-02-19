package yahtzee

object Yahtzee {

  def main(args: Array[String]) {
    val game = new Game
    1 to 13 foreach { _ => game.playRound() }
    println(game)
  }
}
