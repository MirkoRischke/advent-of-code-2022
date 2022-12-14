package day6

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper

class Day6SolverTest : DescribeSpec({

    val solver = Day6Solver()

    describe("first puzzle") {
        describe("sample input") {
            listOf(
                "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
                "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
                "nppdvjthqldpwncqszvftbrmjlhg" to 6,
                "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
                "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11
            ).forAll { (string, expected) ->
                it("returns $expected for $string") {
                    val input = tempfile().run {
                        writeText(string)
                        toPath()
                    }

                    val result = solver.solveFirstPuzzle(input)

                    result shouldBe expected
                }
            }
        }

        it("works for personal input") {
            val input = ResourceHelper.pathFor("/day6/personal_input.txt")

            val result = solver.solveFirstPuzzle(input)

            result shouldBe 1
        }
    }
})
