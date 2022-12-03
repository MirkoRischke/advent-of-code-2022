package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StrategyTest : DescribeSpec({
    describe("to round") {
        listOf(
            Strategy(Column1.A, Column2.Y) to Round(Choice.ROCK, Choice.PAPER),
            Strategy(Column1.B, Column2.X) to Round(Choice.PAPER, Choice.ROCK),
            Strategy(Column1.C, Column2.Z) to Round(Choice.SCISSOR, Choice.SCISSOR)
        ).forAll { input ->
            it("parses strategy ${input.first} to ${input.second}") {
                input.first.toRound() shouldBe input.second
            }
        }
    }
})
