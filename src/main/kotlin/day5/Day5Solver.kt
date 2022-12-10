package day5

import Solver
import java.nio.file.Path
import kotlin.io.path.readLines

class Day5Solver : Solver<String> {
    override fun solveFirstPuzzle(input: Path): String {
        val lines = input.readLines()
        val emptyLineIndex = lines.indexOfFirst { it.isBlank() }

        val storage = SupplyStorage.fromDrawing(lines.subList(0, emptyLineIndex))
        val instructions = lines.subList(emptyLineIndex + 1, lines.size).map { line ->
            Instruction.fromLine(line)
        }

        instructions.forEach {
            storage.moveCrates(it.from, it.to, it.amount)
        }

        return storage.getTopCrates().joinToString("")
    }

    override fun solveSecondPuzzle(input: Path): String {
        return ""
    }
}