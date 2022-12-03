package day2

import java.nio.file.Path
import kotlin.io.path.forEachLine

data class StrategyGuideV2(private val strategies: List<StrategyV2>) {
    fun toMatch(): Match {
        val rounds = strategies.map { it.toRound() }

        return Match(rounds)
    }

    companion object {
        fun fromPath(path: Path): StrategyGuideV2 {
            val strategies = mutableListOf<StrategyV2>()
            path.forEachLine { line ->
                val actions = line.split(" ")
                val enemiesChoice = Column1.valueOf(actions[0])
                val matchResult = Column2.valueOf(actions[1])

                strategies.add(StrategyV2(enemiesChoice, matchResult))
            }
            return StrategyGuideV2(strategies)
        }
    }
}