package day2.game

import day2.game.Choice
import day2.game.Match
import day2.game.Round
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MatchTest : DescribeSpec({

    describe("getScore") {
        it("returns 0 when there are no rounds") {
            Match(emptyList()).getScore() shouldBe 0
        }

        it("returns score of the only existing round") {
            val drawWithRock = Round(Choice.ROCK, Choice.ROCK)

            Match(listOf(drawWithRock)).getScore() shouldBe 4
        }

        it("returns sum of round scores") {
            val victoryWithRock = Round(Choice.SCISSOR, Choice.ROCK) // 6 + 1 = 7
            val drawWithScissor = Round(Choice.SCISSOR, Choice.SCISSOR) // 3 + 3 = 6
            val defeatWithPaper = Round(Choice.SCISSOR, Choice.PAPER) // 0 + 2 = 2
            val rounds = listOf(victoryWithRock, drawWithScissor, defeatWithPaper)

            val score = Match(rounds).getScore()

            score shouldBe 15
        }
    }

})
