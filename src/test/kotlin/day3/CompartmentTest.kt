package day3

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CompartmentTest : BehaviorSpec({

    var compartment = Compartment()
    beforeContainer {
        compartment = Compartment()
    }
    Given("I have a compartment") {

        When("I add an item") {
            val item = Item('a')
            compartment.addItem(item)
            Then("getUniqueItems returns this item") {
                compartment.getUniqueItems() shouldBe setOf(item)
            }
        }

        When("I add two distinct items") {
            val item1 = Item('a')
            val item2 = Item('b')
            compartment.addItem(item1)
            compartment.addItem(item2)
            Then("getUniqueItems returns both items") {
                compartment.getUniqueItems() shouldBe setOf(item1, item2)
            }
        }

        When("I add the same item twice items") {
            val item = Item('a')
            compartment.addItem(item)
            Then("getUniqueItems returns the item") {
                compartment.getUniqueItems() shouldBe setOf(item)
            }
        }
    }
})
