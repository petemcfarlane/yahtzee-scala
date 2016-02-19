package yahtzee

import scala.util.Random

case class DiceRoll(a: Int = 0, b: Int = 0, c: Int = 0, d: Int = 0, e: Int = 0) {

  def values = Seq(rand(a), rand(b), rand(c), rand(d), rand(e))

  override def toString: String = '[' + values.mkString(", ") + ']'

  private def rand(x: Int): Int = if (x == 0) Random.nextInt(6) + 1 else x
}
