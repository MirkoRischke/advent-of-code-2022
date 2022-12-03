package day2

import java.nio.file.Path
import kotlin.io.path.forEachLine

data class StrategyGuide(private val strategies: List<Strategy>) {
    fun toMatch(): Match {
        val rounds = strategies.map { it.toRound() }

        return Match(rounds)
    }

    companion object {
        fun fromPath(path: Path): StrategyGuide {
            val strategies = mutableListOf<Strategy>()
            path.forEachLine { line ->
                val actions = line.split(" ")
                val enemiesChoice = EnemiesEncryptedChoice.valueOf(actions[0])
                val yourChoice = YourEncryptedChoice.valueOf(actions[1])

                strategies.add(Strategy(enemiesChoice, yourChoice))
            }
            return StrategyGuide(strategies)
        }
    }
}