package day5

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InstructionTest : DescribeSpec({
    describe("fromLine") {
        it("parses a single line to an instruction") {
            val line = "move 3 from 2 to 1"

            val instruction = Instruction.fromLine(line)

            instruction shouldBe Instruction(3, 2, 1)
        }
    }

})
