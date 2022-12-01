package day1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlin.math.pow

class SampleTest: BehaviorSpec({
    Given("a positive number") {
        val positiveNumber = 5;
        When("I calculate the power of 2") {
            val result = positiveNumber.toDouble().pow(2.0)
            Then("The result is correct") {
                result shouldBe 25
            }

            Then("The result is false") {
                result shouldBe 24
            }
        }
    }

})