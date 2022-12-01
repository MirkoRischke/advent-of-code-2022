package day1

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class FindElfWithMostCaloriesTest : BehaviorSpec({
    val finder = FindElfWithMostCalories();

    Given("I have an empty list") {
        val elves = emptyList<Elf>()
        Then("it throws an error") {
            val error = shouldThrow<Error> { finder.getPosition(elves) }
            error.message shouldBe "Empty List is not allowed"
        }
    }

    Given("I have a list with one elf") {
        val elves = listOf(Elf())
        Then("it returns 1") {
            finder.getPosition(elves) shouldBe 1
        }
    }

    Given("I have multiple elves") {
        val elves = listOf(
            Elf().apply { addFood(Food(100)) },
            Elf().apply { addFood(Food(300)) },
            Elf().apply { addFood(Food(200)) }
        )
        Then("it returns the position of the elf with the most calories") {
            finder.getPosition(elves) shouldBe 2
        }
    }
})
