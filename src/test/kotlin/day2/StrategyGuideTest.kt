package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class StrategyGuideTest : DescribeSpec({
    describe("toMatch") {
        it("parses empty strategy to empty Match") {
            val emptyStrategies: List<StrategyV1> = emptyList()

            val match = StrategyGuideV1(emptyStrategies).toMatch()

            match shouldBe Match(emptyList())
        }


        it("parses multiple strategies to a whole guide") {
            val strategies = listOf(
                StrategyV1(Column1.A, Column2.Y),
                StrategyV1(Column1.B, Column2.X),
                StrategyV1(Column1.C, Column2.Z),
            )
            val strategyGuide = StrategyGuideV1(strategies)

            val match = strategyGuide.toMatch()

            match shouldBe Match(listOf(
                Round(Choice.ROCK, Choice.PAPER),
                Round(Choice.PAPER, Choice.ROCK),
                Round(Choice.SCISSOR, Choice.SCISSOR),
            ))
        }
    }

    describe("fromPath") {
        it("parses file to strategyGuide") {
            val file = tempfile()
            file.writeText("""
                A Y
                B X
                C Z
            """.trimIndent())

            val strategyGuide = StrategyGuideV1.fromPath(file.toPath())

            val expectedStrategyGuide = StrategyGuideV1(listOf(
                StrategyV1(Column1.A, Column2.Y),
                StrategyV1(Column1.B, Column2.X),
                StrategyV1(Column1.C, Column2.Z),
            ))
            strategyGuide shouldBe expectedStrategyGuide

        }
    }
})
