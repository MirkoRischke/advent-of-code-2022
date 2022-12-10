package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper

class Day4SolverTest : DescribeSpec({

    val solver = Day4Solver()

    describe("puzzle 1") {
        it("example input") {
            val input = ResourceHelper.pathFor("/day4/example_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 2
        }

        it("personal input") {
            val input = ResourceHelper.pathFor("/day4/personal_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 424
        }
    }

    describe("puzzle 2") {
        it("example input") {
            val input = ResourceHelper.pathFor("/day4/example_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe 4
        }

        it("personal input") {
            val input = ResourceHelper.pathFor("/day4/personal_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe 804
        }
    }

})
