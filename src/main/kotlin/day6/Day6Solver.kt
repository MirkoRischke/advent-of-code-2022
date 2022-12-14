package day6

import Solver
import java.nio.file.Path
import kotlin.io.path.readText

private const val PACKET_START_MARKER_SIZE = 4
private const val MESSAGE_START_MARKER_SIZE = 14

class Day6Solver : Solver<Int> {
    override fun solveFirstPuzzle(input: Path): Int {
        val signal = input.readText()
        val startMarkerWindowIndex = uniqueWindowIndex(signal, PACKET_START_MARKER_SIZE)
        return startMarkerWindowIndex + PACKET_START_MARKER_SIZE
    }

    override fun solveSecondPuzzle(input: Path): Int {
        val signal = input.readText()
        val startMarkerWindowIndex = uniqueWindowIndex(signal, MESSAGE_START_MARKER_SIZE)
        return startMarkerWindowIndex + MESSAGE_START_MARKER_SIZE
    }

    private fun uniqueWindowIndex(signal: String, windowSize: Int) = signal
        .windowed(windowSize)
        .indexOfFirst {
            it.toCharArray().isDistinct()
        }
}

fun CharArray.isDistinct(): Boolean {
    return distinct().size == this.size
}
