package day1

import java.nio.file.Path
import kotlin.io.path.readLines

class Solver {

    private val elfParser = BlankLineSeparatedElvesParser()
    private val finder = FindHighestAmountOfCalories()

    fun solve(input: Path): Int {
        val elves = elfParser.createElves(input.readLines())
        return finder.getCalories(elves.toList())
    }
}