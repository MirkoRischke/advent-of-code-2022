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

            When("I ask for the unique items") {
                val uniqueItems = rucksack.findUniqueItems()
                Then("it returns the items from both compartments") {
                    uniqueItems shouldBe setOf(itemA, itemB, itemC)
                }
            }
        }
    }

    Given("I want to create a Rucksack from a string") {
        val string = "abacda"
        val rucksack = Rucksack.fromString(string)
        Then("it puts the first half into the first compartment and the second half into the second compartment") {
            val itemsAB = setOf(Item('a'), Item('b'))
            val itemsCDA = setOf(Item('c'), Item('d'), Item('a'))

            rucksack.firstCompartment.getUniqueItems() shouldBe itemsAB
            rucksack.secondCompartment.getUniqueItems() shouldBe itemsCDA
        }
    }
})
