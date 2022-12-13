package day3

import Solver
import java.nio.file.Path
import kotlin.io.path.useLines

private const val ELF_GROUP_SIZE = 3

class Day3Solver : Solver<Int> {
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
                .chunked(ELF_GROUP_SIZE)
                .sumOf { Item(ElfGroup(it).badge).score }
        }
    }
}
