package day1

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class FindHighestAmountOfCaloriesTest : BehaviorSpec({
    val finder = FindHighestAmountOfCalories();

    Given("I have an empty list") {
        val elves = emptyList<Elf>()
        Then("it throws an error") {
            val error = shouldThrow<Error> { finder.getCalories(elves) }
            error.message shouldBe "Empty List is not allowed"
        }
    }

    Given("I have a list with one elf") {
        val elf = Elf()
        elf.addFood(Food(100))
        elf.addFood(Food(200))

        val elves = listOf(elf)

        Then("it returns its calories") {
            finder.getCalories(elves) shouldBe 300
        }
    }

    Given("I have multiple elves") {
        val poorElf = Elf().apply { addFood(Food(1)) }
        val mediumElf = Elf().apply { addFood(Food(100)) }
        val richElf = Elf()
            .apply { addFood(Food(60)) }
            .apply { addFood(Food(60)) }
        val elves = listOf(poorElf, richElf, mediumElf)

        Then("it returns the position of the elf with the most calories") {
            finder.getCalories(elves) shouldBe 120
        }
    }
})
