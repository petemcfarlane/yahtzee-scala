import org.specs2.mutable.Specification
import yahtzee.categories._
import yahtzee.DiceRoll

class CategoriesSpec extends Specification {
  "A Chance category" >> {
    "should be named \"Chance\"" >> {
      Chance.name should_== "Chance"
    }
    "should evalutae true on any given dice roll" >> {
      val roll = DiceRoll()
      Chance.evaluate(roll) should_== true
    }
    "should score the sum of the dice values" >> {
      val roll = DiceRoll(5, 3, 3, 2, 4)
      Chance.score(roll) should_== 17
    }
  }

  "A Yahtzee category" >> {
    "should be named \"Yahtzee\"" >> {
      Yahtzee.name should_== "Yahtzee"
    }
    "should evaluate true if all dice values are the same" >> {
      val roll = DiceRoll(3, 3, 3, 3, 3)
      Yahtzee.evaluate(roll) should_== true
    }
    "should evaluate false otherwise" >> {
      val roll = DiceRoll(3, 3, 3, 2, 3)
      Yahtzee.evaluate(roll) should_== false
    }
    "should score 50 points" >> {
      val roll = DiceRoll(5, 5, 5, 5, 5)
      Yahtzee.score(roll) should_== 50
    }
  }

  "A second yahtzee category" >> {
    "should be named \"Yahtzee 2\"" >> {
      Yahtzee2.name should_== "Yahtzee 2"
    }
    "should evaluate true if all dice values are the same" >> {
      val roll = DiceRoll(3, 3, 3, 3, 3)
      Yahtzee2.evaluate(roll) should_== true
    }
    "should evaluate false otherwise" >> {
      val roll = DiceRoll(3, 3, 3, 2, 3)
      Yahtzee2.evaluate(roll) should_== false
    }
    "should score 100 points" >> {
      val roll = DiceRoll(5, 5, 5, 5, 5)
      Yahtzee2.score(roll) should_== 100
    }
  }

  "A Null category" >> {
    "should have a blank name" >> {
      NullCategory.name should_== ""
    }
    "will always evaluate true whatever the dice roll" >> {
      NullCategory.evaluate(DiceRoll()) should_== true
    }
    "scores 0 points" >> {
      NullCategory.score(DiceRoll()) should_== 0
    }
  }

  "A Three Of A Kind category" >> {
    "should be named \"Three of a kind\"" >> {
      ThreeOfAKind.name should_== "Three of a kind"
    }
    "will evaluate true if four of the dice are the same value" >> {
      ThreeOfAKind.evaluate(DiceRoll(3, 2, 3, 6, 3)) should_== true
    }
    "will evaluate false otherwise" >> {
      ThreeOfAKind.evaluate(DiceRoll(1, 2, 3, 4, 3)) should_== false
    }
    "scores the sum of the dice roll" >> {
      ThreeOfAKind.score(DiceRoll(2, 3, 5, 6, 2)) should_== 18
    }
  }

  "A Four Of A Kind category" >> {
    "should be named \"Four of a kind\"" >> {
      FourOfAKind.name should_== "Four of a kind"
    }
    "will evaluate true if four of the dice are the same value" >> {
      FourOfAKind.evaluate(DiceRoll(3, 2, 3, 3, 3)) should_== true
    }
    "will evaluate false otherwise" >> {
      FourOfAKind.evaluate(DiceRoll(1, 2, 3, 3, 3)) should_== false
    }
    "scores the sum of the dice roll" >> {
      FourOfAKind.score(DiceRoll(2, 2, 5, 2, 2)) should_== 13
    }
  }

  "A Full House category" >> {
    "should be named \"Full house\"" >> {
      FullHouse.name should_== "Full house"
    }
    "will evaluate true if it contains three of a kind and two of a kind" >> {
      FullHouse.evaluate(DiceRoll(1, 4, 4, 1, 4)) should_== true
    }
    "will evaluate false otherwise" >> {
      FullHouse.evaluate(DiceRoll(1, 1, 1, 2, 5)) should_== false
    }
    "scores 25 points" >> {
      FullHouse.score(DiceRoll(1, 2, 1, 2, 1)) should_== 25
    }
  }

  "A Large Straight category" >> {
    "should be named \"Large straight\"" >> {
      LargeStraight.name should_== "Large straight"
    }
    "will evaluate true if all 5 dice are consecutive" >> {
      LargeStraight.evaluate(DiceRoll(6, 3, 4, 2, 5)) should_== true
    }
    "will evaluate false otherwise" >> {
      LargeStraight.evaluate(DiceRoll(6, 3, 4, 2, 1)) should_== false
    }
    "scores 40 points" >> {
      LargeStraight.score(DiceRoll(1, 2, 3, 4, 5)) should_== 40
    }
  }

  "A Small Straight category" >> {
    "should be named \"Small straight\"" >> {
      SmallStraight.name should_== "Small straight"
    }
    "will evaluate true if at least 4 dice are consecutive" >> {
      SmallStraight.evaluate(DiceRoll(6, 3, 4, 2, 1)) should_== true
    }
    "will evaluate false otherwise" >> {
      SmallStraight.evaluate(DiceRoll(6, 3, 4, 1, 1)) should_== false
    }
    "scores 30 points" >> {
      SmallStraight.score(DiceRoll(1, 2, 3, 4, 6)) should_== 30
    }
  }

  "Ones category" >> {
    "is named \"Ones\"" >> {
      Ones.name should_== "Ones"
    }
    "should always evaluate true" >> {
      Ones.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 1s" >> {
      Ones.score(DiceRoll(1, 1, 4, 2, 5)) should_== 2
    }
  }

  "Twos category" >> {
    "is named \"Twos\"" >> {
      Twos.name should_== "Twos"
    }
    "should always evaluate true" >> {
      Twos.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 2s" >> {
      Twos.score(DiceRoll(2, 1, 4, 2, 5)) should_== 4
    }
  }

  "Threes category" >> {
    "is named \"Threes\"" >> {
      Threes.name should_== "Threes"
    }
    "should always evaluate true" >> {
      Threes.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 3s" >> {
      Threes.score(DiceRoll(2, 1, 4, 2, 5)) should_== 0
    }
  }

  "Fours category" >> {
    "is named \"Fours\"" >> {
      Fours.name should_== "Fours"
    }
    "should always evaluate true" >> {
      Fours.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 4s" >> {
      Fours.score(DiceRoll(2, 1, 4, 2, 5)) should_== 4
    }
  }

  "Fives category" >> {
    "is named \"Fives\"" >> {
      Fives.name should_== "Fives"
    }
    "should always evaluate true" >> {
      Fives.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 5s" >> {
      Fives.score(DiceRoll(2, 1, 4, 2, 5)) should_== 5
    }
  }

  "Sixes category" >> {
    "is named \"Sixes\"" >> {
      Sixes.name should_== "Sixes"
    }
    "should always evaluate true" >> {
      Sixes.evaluate(DiceRoll()) should_== true
    }
    "should score the total amount of 6s" >> {
      Sixes.score(DiceRoll(2, 1, 4, 2, 5)) should_== 0
    }
  }
}
