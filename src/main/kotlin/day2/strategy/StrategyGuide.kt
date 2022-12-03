package day2.strategy

import day2.game.Match
import java.nio.file.Path
import kotlin.io.path.forEachLine

abstract class StrategyGuide(private val strategies: List<Strategy>) {

    fun toMatch(): Match {
        val rounds = strategies.map { it.toRound() }

        return Match(rounds)
    }

    companion object {
        fun <S: Strategy, SG: StrategyGuide> fromPath(
            path: Path,
            strategyConstrutor: (column1: Column1, column2: Column2) -> S,
            strategyGuideConstrutor: (strategies: List<S>) -> SG
        ): SG {
            val strategies = mutableListOf<S>()
            path.forEachLine { line ->
                val actions = line.split(" ")
                val column1 = Column1.valueOf(actions[0])
                val column2 = Column2.valueOf(actions[1])

                strategies.add(strategyConstrutor(column1, column2))
            }
            return strategyGuideConstrutor(strategies)
        }
    }
}