package day5

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CrateMover9001Test : DescribeSpec({

    val crane = CrateMover9001()

    describe("moveCrates") {
        it("moves multiple crates at once") {
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
            stack2.getCrates() shouldBe listOf("D", "E", "F", "B", "C")
        }
    }

})
