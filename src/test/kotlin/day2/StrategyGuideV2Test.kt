package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class StrategyGuideV2Test : DescribeSpec({

    describe("toMatch") {
        it("parses empty strategy to empty Match") {
            val emptyStrategies: List<StrategyV2> = emptyList()

            val match = StrategyGuideV2(emptyStrategies).toMatch()

            match shouldBe Match(emptyList())
        }

        it("parses multiple strategies to a whole guide") {
            val strategies = listOf(
                StrategyV2(Column1.A, Column2.Y),
                StrategyV2(Column1.B, Column2.X),
                StrategyV2(Column1.C, Column2.Z),
            )
            val strategyGuide = StrategyGuideV2(strategies)

            val match = strategyGuide.toMatch()

            match shouldBe Match(listOf(
                Round(Choice.ROCK, Choice.ROCK),
                Round(Choice.PAPER, Choice.ROCK),
                Round(Choice.SCISSOR, Choice.ROCK),
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

            val strategyGuide = StrategyGuideV2.fromPath(file.toPath())

            val expectedStrategyGuide = StrategyGuideV2(listOf(
                StrategyV2(Column1.A, Column2.Y),
                StrategyV2(Column1.B, Column2.X),
                StrategyV2(Column1.C, Column2.Z),
            ))
            strategyGuide shouldBe expectedStrategyGuide

        }
    }

})
