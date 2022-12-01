package day1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.nio.file.Path
import java.nio.file.Paths

class SolverTest : BehaviorSpec({

    val solver = Solver()

    Given("I have the example input") {
        val file: Path = Paths.get(this.javaClass.getResource("/day1/example_input.txt")!!.toURI())

        Then("it returns 4") {
            solver.solve(file) shouldBe 24000
        }
    }

    Given("I have my personal input") {
        val file: Path = Paths.get(this.javaClass.getResource("/day1/personal_input.txt")!!.toURI())

        Then("it returns 4") {
            solver.solve(file) shouldBe 65912
        }
    }

})
