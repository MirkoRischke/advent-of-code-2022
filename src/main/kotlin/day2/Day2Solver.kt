package day2

import Solver
import day2.strategy.StrategyGuideV1
import day2.strategy.StrategyGuideV2
import java.nio.file.Path

class Day2Solver : Solver<Int> {

    override fun solveFirstPuzzle(input: Path): Int {
        return StrategyGuideV1.fromPath(input)
            .toMatch()
            .getScore()
    }

    override fun solveSecondPuzzle(input: Path): Int {
        return StrategyGuideV2.fromPath(input)
            .toMatch()
            .getScore()
    }
}
