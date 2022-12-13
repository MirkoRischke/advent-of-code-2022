package day5

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper

class Day5SolverTest : DescribeSpec({

    val solver = Day5Solver()

    describe("puzzle 1") {
        it("example input") {
            val input = ResourceHelper.pathFor("/day5/example_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe "CMZ"
        }

        it("personal input") {
            val input = ResourceHelper.pathFor("/day5/personal_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe "RFFFWBPNS"
        }
    }

    describe("puzzle 2") {
        it("example input") {
            val input = ResourceHelper.pathFor("/day5/example_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe "MCD"
        }

        it("personal input") {
            val input = ResourceHelper.pathFor("/day5/personal_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe "CQQBBJFCS"
        }
    }

})
