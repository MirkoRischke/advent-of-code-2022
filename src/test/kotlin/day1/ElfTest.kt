package day1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ElfTest : BehaviorSpec({

    Given("An elf") {
        var elf = Elf()

        afterEach {
            elf = Elf()
        }

        When("I do not add food") {
            Then("It cas 0 calories") {
                elf.getTotalCalories() shouldBe 0
            }
        }

        When("I add one food item") {
            val calories = 1000
            val someFood = Food(calories)
            elf.addFood(someFood)

            Then("the total amount of calories equals the calories of the food item") {
                elf.getTotalCalories() shouldBe calories
            }
        }

        When("I add multiple food items") {
            elf.addFood(Food(1000))
            elf.addFood(Food(2000))

            Then("the total amount of calories equals the sum of the calories of the food items") {
                elf.getTotalCalories() shouldBe 3000
            }
        }
    }
})
