package day2

class StrategyGuide(private val strategies: List<Strategy>) {
    fun toMatch(): Match {
        val rounds = strategies.map { it.toRound() }

        return Match(rounds)
    }
}