package day1

import Solver
import java.nio.file.Path
import kotlin.io.path.readLines

private const val AMOUNT_OF_RICHEST_ELVES = 3

class Day1Solver : Solver<Int> {

    private val elfParser = BlankLineSeparatedElvesParser()
    private val finder = FindHighestAmountOfCalories()

    override fun solveFirstPuzzle(input: Path): Int {
        val elves = elfParser.createElves(input.readLines())
        return finder.getMaximumCalories(elves.toList())
    }

    override fun solveSecondPuzzle(input: Path): Int {
        val elves = elfParser.createElves(input.readLines())
        return finder.getCaloriesOfRichestElves(elves.toList(), AMOUNT_OF_RICHEST_ELVES)
    }
}
