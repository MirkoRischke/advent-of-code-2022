package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper.pathFor

class Day2SolverTest : DescribeSpec({

    val solver = Day2Solver()

    describe("first puzzle") {
        it("returns the correct result for the example") {
            val input = pathFor("/day2/example_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 15
        }

        it("returns the correct result for my personal input") {
            val input = pathFor("/day2/personal_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 12772
        }
    }

    describe("second puzzle") {
        it("returns the correct result for the example") {
            val input = pathFor("/day2/example_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe 12
        }

        it("returns the correct result for my personal input") {
            val input = pathFor("/day2/personal_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe 11618
        }
    }
})
