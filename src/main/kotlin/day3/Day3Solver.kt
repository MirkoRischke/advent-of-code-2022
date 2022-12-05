package day3

import Solver
import java.nio.file.Path
import kotlin.io.path.useLines

class Day3Solver : Solver {
    override fun solveFirstPuzzle(input: Path): Int {
        return input.useLines { lines ->
            lines.sumOf { line ->
                Rucksack.fromString(line)
                    .findDuplicatedItem()
                    .score
            }
        }
    }

    override fun solveSecondPuzzle(input: Path): Int {
        return input.useLines { lines ->
            lines
                .map { Rucksack.fromString(it) }
                .chunked(3)
                .sumOf { Item(ElfGroup(it).badge).score }
        }
    }
}