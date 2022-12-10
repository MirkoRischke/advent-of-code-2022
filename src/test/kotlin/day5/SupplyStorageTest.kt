package day5

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SupplyStorageTest : DescribeSpec({

    describe("getStack") {
        it("returns stack at position, counting from 1") {
            val stack1 = Stack(listOf("A"))
            val stack2 = Stack(listOf("B", "C"))
            val stack3 = Stack(listOf("D", "E", "F"))
            val storage = SupplyStorage(listOf(stack1, stack2, stack3))

            storage.getStack(1) shouldBe stack1
            storage.getStack(2) shouldBe stack2
            storage.getStack(3) shouldBe stack3
        }
    }
    describe("moveCrate") {
        it("moves one container from one stack to another one") {
            val storage = SupplyStorage(
                listOf(
                    Stack(listOf("A")),
                    Stack(listOf("B", "C")),
                    Stack(listOf("D", "E", "F")),
                )
            )

            storage.moveCrate(3, 1)

            assertSoftly {
                storage.getStack(1).topCrate shouldBe "F"
                storage.getStack(2).topCrate shouldBe "C"
                storage.getStack(3).topCrate shouldBe "E"
            }
        }
    }

    describe("moveCrates") {
        it("moves multiple container from one stack to another step by step") {
            val storage = SupplyStorage(
                listOf(
                    Stack(listOf("A")),
                    Stack(listOf("B", "C")),
                    Stack(listOf("D", "E", "F")),
                )
            )

            storage.moveCrates(3, 1, 2)

            assertSoftly {
                storage.getStack(1).topCrate shouldBe "E"
                storage.getStack(2).topCrate shouldBe "C"
                storage.getStack(3).topCrate shouldBe "D"
            }
        }
    }

})
