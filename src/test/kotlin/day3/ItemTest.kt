package day3

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.string.shouldStartWith
import io.kotest.property.Arb
import io.kotest.property.arbitrary.char
import io.kotest.property.checkAll
import io.kotest.property.withAssumptions

class ItemTest : BehaviorSpec({

    Given("I want to create an item") {
        val validCharacterRanges = listOf(
            CharRange('a', 'z'),
            CharRange('A', 'Z'),
        )

        checkAll(Arb.char(validCharacterRanges)) { validChar ->
            And("I use the valid char $validChar") {
                Then("I can create an item for it") {
                    shouldNotThrowAny { Item(validChar) }
                }
            }
        }

        checkAll<Char> { char ->
            withAssumptions(validCharacterRanges.none { it.contains(char) }) {
                And("I use the invalid char $char") {
                    Then("it fails") {
                        val error = shouldThrow<IllegalArgumentException> { Item(char) }
                        error.message shouldStartWith "Only letters are allowed (a-z,A-Z)"
                    }
                }
            }
        }
    }


})
