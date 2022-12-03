package day2

import day2.strategy.StrategyGuideV1
import day2.strategy.StrategyGuideV2
import java.nio.file.Path

class Solver {

    fun solveFirstPuzzle(input: Path): Int {
        return StrategyGuideV1.fromPath(input)
            .toMatch()
            .getScore()
    }

    fun solveSecondPuzzle(input: Path): Int {
        return StrategyGuideV2.fromPath(input)
            .toMatch()
            .getScore()
    }
}