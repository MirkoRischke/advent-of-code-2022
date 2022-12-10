package day5

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StackTest : DescribeSpec({

    describe("topCrate") {
        it("returns the last crate from constructor") {
            val crates = listOf("A", "B")
            val stack = Stack(crates)

            stack.topCrate shouldBe "B"
        }
    }

    describe("addCrate") {
        it("adds new crate on top of the stack") {
            val stack = Stack().apply {
                addCrate("A")
                addCrate("B")
            }

            stack.topCrate shouldBe "B"
        }
    }

    describe("removeCrate") {
        it("removes crate from the top of the stack and returns it") {
            val stack = Stack().apply {
                addCrate("A")
                addCrate("B")
            }

            val crate = stack.removeCrate()

            stack.topCrate shouldBe "A"
            crate shouldBe "B"
        }
    }


})
