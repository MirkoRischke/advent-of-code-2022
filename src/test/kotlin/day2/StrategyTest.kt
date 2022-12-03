package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StrategyTest : DescribeSpec({
    describe("to round") {
        listOf(
            Strategy(EnemiesEncryptedChoice.A, YourEncryptedChoice.Y) to Round(Choice.ROCK, Choice.PAPER),
            Strategy(EnemiesEncryptedChoice.B, YourEncryptedChoice.X) to Round(Choice.PAPER, Choice.ROCK),
            Strategy(EnemiesEncryptedChoice.C, YourEncryptedChoice.Z) to Round(Choice.SCISSOR, Choice.SCISSOR)
        ).forAll { input ->
            it("parses strategy ${input.first} to ${input.second}") {
                input.first.toRound() shouldBe input.second
            }
        }
    }
})
