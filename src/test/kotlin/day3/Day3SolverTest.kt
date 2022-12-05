package day3

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper

class Day3SolverTest : BehaviorSpec({

    val solver = Day3Solver()

    Given("First puzzle") {
        And("the sample input") {
            val input = ResourceHelper.pathFor("/day3/example_input.txt")
            When("I solve it") {
                val result = solver.solveFirstPuzzle(input)
                Then("the result is 157") {
                    result shouldBe 157
                }
            }
        }

        And("my personal input") {
            val input = ResourceHelper.pathFor("/day3/personal_input.txt")
            When("I solve it") {
                val result = solver.solveFirstPuzzle(input)
                Then("the result is X") {
                    result shouldBe 7716
                }
            }
        }
    }
})
