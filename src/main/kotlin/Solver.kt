import java.nio.file.Path

interface Solver<T> {
    fun solveFirstPuzzle(input: Path): T

    fun solveSecondPuzzle(input: Path): T
}
