package day1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import testutils.ResourceHelper.pathFor

class SolverTest : BehaviorSpec({

    val solver = Solver()

    Given("I have the example input") {
        val file = pathFor("/day1/example_input.txt")
        When("I solve the first puzzle") {
            val solution = solver.firstSolution(file)

            Then("the solution is 4") {
                solution shouldBe 24000
            }
        }

        When("I solve the second puzzle") {
            val solution = solver.secondSolution(file)
            Then("the solution is 45000") {
                solution shouldBe 45000
            }
        }
    }

    Given("I have my personal input") {
        val file = pathFor("/day1/personal_input.txt")

        When("I solve the first puzzle") {
            val solution = solver.firstSolution(file)

            Then("the solution is 4") {
                solution shouldBe 65912
            }
        }

        When("I solve the second puzzle") {
            val solution = solver.secondSolution(file)
            Then("the solution is 45000") {
                solution shouldBe 195625
            }
        }
    }

})
