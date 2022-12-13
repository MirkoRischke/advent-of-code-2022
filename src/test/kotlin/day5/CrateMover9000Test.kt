package day5

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CrateMover9000Test : DescribeSpec({

    val crane = CrateMover9000()

    describe("moveCrates") {
        it("moves one container at a time") {
            val stack1 = Stack(listOf(
                "A",
                "B",
                "C"
            ))
            val stack2 = Stack(listOf(
                "D",
                "E",
                "F",
            ))

            crane.moveCrates(stack1, stack2, 2)

            stack1.getCrates() shouldBe listOf("A")
            stack2.getCrates() shouldBe listOf("D", "E", "F", "C", "B")
        }
    }

})
