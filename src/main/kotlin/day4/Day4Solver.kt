package day4

import Solver
import java.nio.file.Path

class Day4Solver : Solver<Int> {
    override fun solveFirstPuzzle(input: Path): Int {
        return SectionAssignmentPairs.fromPath(input)
            .countObsoleteAssignmentPairs()
    }

    override fun solveSecondPuzzle(input: Path): Int {
        return SectionAssignmentPairs.fromPath(input)
            .countOverlappingAssignmentPairs()
    }
}