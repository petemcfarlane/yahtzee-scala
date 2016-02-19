package yahtzee.categories

import yahtzee.DiceRoll

sealed trait Category {
  val name: String

  def evaluate(diceRoll: DiceRoll): Boolean

  def score(diceRoll: DiceRoll): Int
}

case object Chance extends Category {
  val name = "Chance"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.sum
}

case object NullCategory extends Category {
  val name = ""

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = 0
}

case object Yahtzee extends Category {
  val name = "Yahtzee"

  def evaluate(diceRoll: DiceRoll) = diceRoll.values.distinct.size == 1

  def score(diceRoll: DiceRoll) = 50
}

case object Yahtzee2 extends Category {
  val name = "Yahtzee 2"

  def evaluate(diceRoll: DiceRoll) = diceRoll.values.distinct.size == 1

  def score(diceRoll: DiceRoll) = 100
}

case object ThreeOfAKind extends Category {
  val name = "Three of a kind"

  def evaluate(diceRoll: DiceRoll) = diceRoll.values.groupBy(identity).exists(_._2.length == 3)

  def score(diceRoll: DiceRoll) = diceRoll.values.sum
}

case object FourOfAKind extends Category {
  val name = "Four of a kind"

  def evaluate(diceRoll: DiceRoll) = diceRoll.values.groupBy(identity).exists(_._2.length == 4)

  def score(diceRoll: DiceRoll) = diceRoll.values.sum
}

case object FullHouse extends Category {
  val name = "Full house"

  def evaluate(diceRoll: DiceRoll) = {
    val grouped = diceRoll.values.groupBy(identity)
    grouped.exists(_._2.length == 3) && grouped.size == 2
  }

  def score(diceRoll: DiceRoll) = 25
}

case object LargeStraight extends Category {
  val name = "Large straight"

  def evaluate(diceRoll: DiceRoll) = diceRoll.values.sorted == Seq(1, 2, 3, 4, 5) || diceRoll.values.sorted == Seq(2, 3, 4, 5, 6)

  def score(diceRoll: DiceRoll) = 40
}

case object SmallStraight extends Category {
  val name = "Small straight"

  def evaluate(diceRoll: DiceRoll) = {
    val sorted = diceRoll.values.sorted
    sorted.containsSlice(Seq(1, 2, 3, 4)) || sorted.containsSlice(Seq(2, 3, 4, 5)) || sorted.containsSlice(Seq(3, 4, 5, 6))
  }

  def score(diceRoll: DiceRoll) = 30
}

case object Ones extends Category {
  val name = "Ones"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 1)
}

case object Twos extends Category {
  val name = "Twos"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 2) * 2
}

case object Threes extends Category {
  val name = "Threes"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 3) * 3
}

case object Fours extends Category {
  val name = "Fours"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 4) * 4
}

case object Fives extends Category {
  val name = "Fives"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 5) * 5
}

case object Sixes extends Category {
  val name = "Sixes"

  def evaluate(diceRoll: DiceRoll) = true

  def score(diceRoll: DiceRoll) = diceRoll.values.count(_ == 6) * 6
}
