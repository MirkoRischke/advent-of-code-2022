package day6

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper

class Day6SolverTest : DescribeSpec({

    val solver = Day6Solver()

    describe("charArray.isDistinct") {
        it("returns true when there are only distinct chars") {
            val uniqueChars = "abc"
            val result = uniqueChars.toCharArray().isDistinct()

            result shouldBe true
        }

        it("returns false when there are duplicated chars") {
            val duplicatedA = "abac"

            val result = duplicatedA.toCharArray().isDistinct()

            result shouldBe false
        }
    }

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

            result shouldBe 1578
        }
    }

    describe("second puzzle") {
        describe("sample input") {
            listOf(
                "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
                "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
                "nppdvjthqldpwncqszvftbrmjlhg" to 23,
                "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
                "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26
            ).forAll { (string, expected) ->
                it("returns $expected for $string") {
                    val input = tempfile().run {
                        writeText(string)
                        toPath()
                    }

                    val result = solver.solveSecondPuzzle(input)

                    result shouldBe expected
                }
            }
        }

        it("works for personal input") {
            val input = ResourceHelper.pathFor("/day6/personal_input.txt")

            val result = solver.solveSecondPuzzle(input)

            result shouldBe 2178
        }
    }
})
