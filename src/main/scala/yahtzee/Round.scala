package yahtzee

import yahtzee.categories.{NullCategory, Category}

class Round(private val possibleCategories: List[Category], val diceRoll: DiceRoll) {

  def this(possibleCategories: List[Category]) = this(possibleCategories, new DiceRoll())

  val (category, remainingCategories): (Category, List[Category]) = {
    val c = possibleCategories.find(c => c.evaluate(diceRoll)).getOrElse(NullCategory)
    (c, possibleCategories.diff(List(c)))
  }

  val score: Int = category.score(diceRoll)

  override def toString: String = f"$diceRoll | ${category.name}%-15s | $score"
}
