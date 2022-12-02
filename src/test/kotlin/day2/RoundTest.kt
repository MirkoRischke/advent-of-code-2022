package day2

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundTest : DescribeSpec({

    describe("getOutcome") {
        describe("draws") {
            Choice.values().forEach { choice ->
                it("returns draw when both players chose ${choice.name}") {
                    Round(choice, choice).getResult() shouldBe Result.DRAW
                }
            }
        }

        describe("victories") {
            listOf(
                Choice.ROCK to Choice.SCISSOR,
                Choice.PAPER to Choice.ROCK,
                Choice.SCISSOR to Choice.PAPER
            ).forEach { combination ->
                it("returns victory when I chose ${combination.first} and my enemy ${combination.second} ") {
                    Round(combination.first, combination.second).getResult() shouldBe Result.VICTORY
                }
            }
        }

        describe("defeats") {
            listOf(
                Choice.ROCK to Choice.PAPER,
                Choice.PAPER to Choice.SCISSOR,
                Choice.SCISSOR to Choice.ROCK
            ).forEach { combination ->
                it("returns defeat when I chose ${combination.first} and my enemy ${combination.second} ") {
                    Round(combination.first, combination.second).getResult() shouldBe Result.DEFEAT
                }
            }
        }

    }
})
