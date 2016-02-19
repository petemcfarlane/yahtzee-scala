package yahtzee

import yahtzee.categories._

class Game {
  val scoreboard = new Scoreboard

  var categories: List[Category] = List(yahtzee.categories.Yahtzee, LargeStraight, SmallStraight, FullHouse, FourOfAKind, ThreeOfAKind, Chance, Sixes, Fives, Fours, Threes, Twos, Ones)

  def playRound(diceRoll: Option[DiceRoll] = None) = {
    if (scoreboard.rounds.length >= 13) throw new RuntimeException("Can only play 13 rounds")
    val round = new Round(categories, diceRoll.getOrElse(DiceRoll()))
    categories = round.remainingCategories
    scoreboard.addRound(round)
  }

  override def toString = {
    """Round | Dice roll       | Category        | Score
      |======|=================|=================|======
      |""".stripMargin +
        scoreboard.rounds.zipWithIndex.map(t => {
          val r = t._1
          val i = t._2 + 1
        f"$i%5d | $r"
      }).mkString("\n") + "\n" +
    "Total: " + scoreboard.total
  }

}

