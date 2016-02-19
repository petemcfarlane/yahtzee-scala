import org.specs2.mutable.Specification
import yahtzee.categories.{Category, Yahtzee, Chance}
import yahtzee.{DiceRoll, Round}

class RoundSpec extends Specification {
  val cs: List[Category] = List(Yahtzee, Chance)
  val diceRoll = new DiceRoll(4, 4, 4, 4, 4)
  val r = new Round(cs, diceRoll)
  "A round" >> {
    "is created with possible yahtzee.categories" >> {
      r should beAnInstanceOf[Round]
    }
    "has a dice roll" >> {
      r.diceRoll should_== diceRoll
    }
    "a category" >> {
      r.category should_== Yahtzee
    }
    "with a score" >> {
      r.score should_== 50
    }
    "and remaining yahtzee.categories" >> {
      r.remainingCategories should_== List(Chance)
    }
  }

  "A round can also be represented as a string" >> {
    r.toString should_== "[4, 4, 4, 4, 4] | Yahtzee         | 50"
  }
}
