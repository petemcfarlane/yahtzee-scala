package yahtzee

class Scoreboard {
  var rounds: List[Round] = Nil

  def addRound(round: Round) { rounds = rounds :+ round }

  def total = rounds.map(_.score).sum
}
