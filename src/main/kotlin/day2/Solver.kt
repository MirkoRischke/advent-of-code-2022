package day2

import java.nio.file.Path

class Solver {

    fun solveFirstPuzzle(input: Path): Int {
        return StrategyGuide.fromPath(input)
            .toMatch()
            .getScore()
    }
}