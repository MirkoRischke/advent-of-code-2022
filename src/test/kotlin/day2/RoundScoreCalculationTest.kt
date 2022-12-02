package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundScoreCalculationTest : DescribeSpec({

    val victoryProvider = RoundResultProvider { Result.VICTORY }
    val drawProvider = RoundResultProvider { Result.DRAW }
    val defeatProvider = RoundResultProvider { Result.DEFEAT }

    describe("I win") {
        listOf(
            Choice.ROCK to 7,
            Choice.PAPER to 8,
            Choice.SCISSOR to 9,
        ).forEach {
            it("by choosing ${it.first}, then I get ${it.second} points") {
                RoundScoreCalculation().getScore(it.first, victoryProvider) shouldBe it.second
            }
        }

    }

    describe("I draw") {
        listOf(
            Choice.ROCK to 4,
            Choice.PAPER to 5,
            Choice.SCISSOR to 6,
        ).forEach {
            it("by choosing ${it.first}, then I get ${it.second} points") {
                RoundScoreCalculation().getScore(it.first, drawProvider) shouldBe it.second
            }
        }
    }

    describe("I lose") {
        listOf(
            Choice.ROCK to 1,
            Choice.PAPER to 2,
            Choice.SCISSOR to 3,
        ).forEach {
            it("by choosing ${it.first}, then I get ${it.second} points") {
                RoundScoreCalculation().getScore(it.first, defeatProvider) shouldBe it.second
            }
        }
    }
})
