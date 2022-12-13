package day1

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class FindHighestAmountOfCaloriesTest : BehaviorSpec({
    val finder = FindHighestAmountOfCalories()

    Given("I have an empty list") {
        val elves = emptyList<Elf>()

        When("I try to get the maximum amount of calories") {
            Then("it throws an error") {
                val error = shouldThrow<NoElvesPresent> { finder.getMaximumCalories(elves) }
                error.message shouldBe "Empty List is not allowed"
            }
        }

        When("I try to get the total amount of calories of the three best supplied elves") {
            Then("it throws an error") {
                val error = shouldThrow<NoElvesPresent> { finder.getCaloriesOfRichestElves(elves, 3) }
                error.message shouldBe "Empty List is not allowed"
            }
        }
    }

    Given("I have a list with one elf") {
        val elf = Elf()
        elf.addFood(Food(100))
        elf.addFood(Food(200))

        val elves = listOf(elf)

        When("I get the maximum amount of calories") {
            val solution = finder.getMaximumCalories(elves)
            Then("it returns its calories") {
                solution shouldBe 300
            }
        }

        When("I get the total amount of calories of the three best supplied elves") {
            val solution = finder.getCaloriesOfRichestElves(elves, 3)
            Then("it returns its calories") {
                solution shouldBe 300
            }
        }
    }

    Given("I have multiple elves") {
        val poorElf = Elf().apply { addFood(Food(1)) }
        val mediumElf1 = Elf().apply { addFood(Food(2)) }
        val mediumElf2 = Elf().apply { addFood(Food(3)) }
        val richElf = Elf()
            .apply { addFood(Food(4)) }
            .apply { addFood(Food(4)) }
        val elves = listOf(mediumElf2, poorElf, richElf, mediumElf1)

        When("I get the maximum amount of calories") {
            val solution = finder.getMaximumCalories(elves)
            Then("it returns its calories") {
                solution shouldBe 8
            }
        }

        When("I get the total amount of calories of the three best supplied elves") {
            val solution = finder.getCaloriesOfRichestElves(elves, 3)
            Then("it returns its calories") {
                solution shouldBe 13
            }
        }
    }
})
