package day3

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RucksackTest : BehaviorSpec({

    Given("I have a Rucksack") {
        val rucksack = Rucksack()
        And("I add item A to both compartments") {
            val itemA = Item('a')
            val itemB = Item('b')
            val itemC = Item('c')

            rucksack.firstCompartment.apply {
                addItem(itemA)
                addItem(itemB)
            }
            rucksack.secondCompartment.apply {
                addItem(itemA)
                addItem(itemC)
            }
            When("I ask for the duplicated item") {
                val duplicatedItem = rucksack.findDuplicatedItem()

                Then("it returns item A") {
                    duplicatedItem shouldBe itemA
                }
            }
        }
    }
})
