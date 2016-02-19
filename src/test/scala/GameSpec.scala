import org.specs2.mutable.Specification
import yahtzee.categories._
import yahtzee.{Scoreboard, Game, Round}

class GameSpec extends Specification {
  "A game of yahtzee consists of" >> {
    val g = new Game
    "a scoreboard" >> {
      g.scoreboard should beAnInstanceOf[Scoreboard]
    }
    "13 possible yahtzee.categories" >> {
      g.categories should_== List(Chance, Fives, FourOfAKind, Fours, FullHouse, LargeStraight, Ones, Sixes, SmallStraight, ThreeOfAKind, Threes, Twos, Yahtzee)
    }
  }
  "A player can play a round" >> {
    val g = new Game
    g.playRound()
    g.scoreboard.rounds.head should beAnInstanceOf[Round]
  }
  "only up to 13 rounds" >> {
    val g = new Game
    1 to 13 foreach { _ => g.playRound() }

    g.playRound() should throwAn[RuntimeException]
  }

}
