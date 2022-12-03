package day2.game

data class Match(private val rounds: List<Round>) {
    fun getScore(): Score {
        return rounds.sumOf { round -> round.getScore() }
    }
}