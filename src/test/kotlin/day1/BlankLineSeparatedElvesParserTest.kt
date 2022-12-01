package day1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class BlankLineSeparatedElvesParserTest : BehaviorSpec({

    val parser = BlankLineSeparatedElvesParser()

    Given("An empty list of elves") {
        val rawData = ""

        When("I parse that list") {
            val elves = parser.createElves(rawData.lines())
            Then("it returns an empty list") {
                elves shouldBe emptyList()
            }
        }
    }

    Given("A list of one elf with multiple food items") {
        val rawData = """
            10
            20
            30
        """.trimIndent()

        When("I parse that list") {
            val elves = parser.createElves(rawData.lines())
            Then("I get a list of one elf with the right amount of calories") {
                elves shouldHaveSize 1
                elves.first().getTotalCalories() shouldBe 60
            }
        }
    }

    Given("A list with multiple elves and their food items") {
        val rawData = """
            1
            
            1
            2
            
            1
            2
            3
        """.trimIndent()
        When("I parse that list") {
            val elves = parser.createElves(rawData.lines()).toList()
            Then("I get a list of multiple elves with their respective sum of calories") {
                elves shouldHaveSize 3
                elves[0].getTotalCalories() shouldBe 1
                elves[1].getTotalCalories() shouldBe 3
                elves[2].getTotalCalories() shouldBe 6
            }
        }
    }
})
