package day6

import Solver
import java.nio.file.Path
import kotlin.io.path.readText

private const val MARKER_SIZE = 4

class Day6Solver : Solver<Int> {
    override fun solveFirstPuzzle(input: Path): Int {
        val signal = input.readText()
        val startMarkerWindowIndex = signal
            .windowed(MARKER_SIZE)
            .indexOfFirst {
                it.toCharArray().isDistinct()
            }
        return startMarkerWindowIndex + MARKER_SIZE
    }

    override fun solveSecondPuzzle(input: Path): Int {
        return 0
    }
}

fun CharArray.isDistinct(): Boolean {
    return distinct().size == this.size
}
