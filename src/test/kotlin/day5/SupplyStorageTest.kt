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
            val storage = SupplyStorageMother.aSupplyStorage(stacks = listOf(stack1, stack2, stack3))

            storage.getStack(1) shouldBe stack1
            storage.getStack(2) shouldBe stack2
            storage.getStack(3) shouldBe stack3
        }
    }

    describe("moveCrates") {
        it("moves multiple container from one stack to another step by step") {
            val storage = SupplyStorageMother.aSupplyStorage(
                stacks = listOf(
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

    describe("getTopCrates") {
        it("returns the crates at the top of all the stacks") {
            val storage = SupplyStorageMother.aSupplyStorage(
                stacks = listOf(
                    Stack(listOf("A")),
                    Stack(listOf("B", "C")),
                    Stack(listOf("D", "E", "F")),
                )
            )

            val result = storage.getTopCrates()

            result shouldBe listOf("A", "C", "F")
        }
    }

    describe("fromDrawing") {
        it("creates the storage from the drawing") {
            val drawing = """
                    [D]    
                    [N] [C]    
                    [Z] [M] [P]
                     1   2   3
            """.trimIndent().lines()

            val storage = SupplyStorage.fromDrawing(drawing, CrateMover9000())

            storage.getStack(1).topCrate shouldBe "D"
            storage.getStack(2).topCrate shouldBe "C"
            storage.getStack(3).topCrate shouldBe "P"
        }
    }
})
