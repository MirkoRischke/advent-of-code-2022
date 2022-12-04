import java.nio.file.Path

interface Solver {
    fun solveFirstPuzzle(input: Path): Int

    fun solveSecondPuzzle(input: Path): Int
}