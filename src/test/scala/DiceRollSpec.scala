import org.specs2.mutable.Specification
import yahtzee.DiceRoll

class DiceRollSpec extends Specification {
  "A dice roll" >> {
    "should have five values" >> {
      val diceRoll = DiceRoll(1, 2, 3, 4, 5)
      diceRoll.values should_== Seq(1, 2, 3, 4, 5)
    }
    "has random values assigned if none are passed" >> {
      val diceRoll = DiceRoll()
      diceRoll.values.length must_== 5
    }
    "can set one or more dice value directly" >> {
      val diceRoll = DiceRoll(3, 3, 3)
      diceRoll.values must contain(3, 3, 3)
    }
    "can be represented as a string" >> {
      DiceRoll(2, 3, 5, 6, 1).toString should_== "[2, 3, 5, 6, 1]"
    }
  }
}
