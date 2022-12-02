package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.nio.file.Paths

class SolverTest : DescribeSpec({

    val solver = Solver()

    describe("first puzzle") {
        it("returns the correct result for the example") {
            val input = Paths.get(this.javaClass.getResource("/day1/example_input.txt")!!.toURI())

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 15
        }

        it("returns the correct result for my personal input") {
            val input = Paths.get(this.javaClass.getResource("/day1/personal_input.txt")!!.toURI())

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 15
        }
    }
})