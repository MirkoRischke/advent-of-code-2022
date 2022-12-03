package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StrategyGuideTest : DescribeSpec({
    describe("toMatch") {
        it("parses empty strategy to empty Match") {
            val emptyStrategies: List<Strategy> = emptyList()

            val match = StrategyGuide(emptyStrategies).toMatch()

            match shouldBe Match(emptyList())
        }


        it("parses multiple strategies to a whole guide") {
            val strategies = listOf(
                Strategy(EnemiesEncryptedChoice.A, YourEncryptedChoice.Y),
                Strategy(EnemiesEncryptedChoice.B, YourEncryptedChoice.X),
                Strategy(EnemiesEncryptedChoice.C, YourEncryptedChoice.Z),
            )
            val strategyGuide = StrategyGuide(strategies)

            val match = strategyGuide.toMatch()

            match shouldBe Match(listOf(
                Round(Choice.ROCK, Choice.PAPER),
                Round(Choice.PAPER, Choice.ROCK),
                Round(Choice.SCISSOR, Choice.SCISSOR),
            ))
        }
    }
})
