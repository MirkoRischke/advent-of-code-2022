package day3

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ElfGroupTest : BehaviorSpec({

    Given("An elf group") {
        val commonItem = Item('X')
        val rucksack1 = Rucksack().apply {
            firstCompartment.addItem(commonItem)
            secondCompartment.addItem(Item('a'))
            firstCompartment.addItem(Item('b'))
        }
        val rucksack2 = Rucksack().apply {
            firstCompartment.addItem(Item('b'))
            secondCompartment.addItem(commonItem)
        }
        val rucksack3 = Rucksack().apply {
            secondCompartment.addItem(commonItem)
            firstCompartment.addItem(Item('a'))
        }

        val elfGroup = ElfGroup(listOf(rucksack1, rucksack2, rucksack3))

        When("I ask for the badge") {
            val badge = elfGroup.badge
            Then("it returns the letter of the common item") {
                badge shouldBe commonItem.letter
            }
        }
    }

})
