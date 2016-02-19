import org.specs2.mutable.Specification
import yahtzee.categories.Chance
import yahtzee.{Round, Scoreboard, DiceRoll}

class ScoreboardSpec extends Specification {
  "A scoreboard" >> {
    val s = new Scoreboard
    "has 13 rounds" >> {
      s.rounds.length should be_<=(13)
    }
    "can score a round" >> {
      val round = new Round(List())
      s.addRound(round)
      s.rounds should_== List(round)
    }
    "has a total score" >> {
      val s = new Scoreboard
      val round = new Round(List(Chance), DiceRoll(3, 4, 2, 6, 4))
      s.addRound(round)

      s.total should_== 19
    }
  }

}
