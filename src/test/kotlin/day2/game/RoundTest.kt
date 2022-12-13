package day2.game

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundTest : DescribeSpec({

    describe("getResult") {
        describe("draws") {
            Choice.values().forEach { choice ->
                it("returns draw when both players chose ${choice.name}") {
                    Round(choice, choice).getResult() shouldBe Result.DRAW
                }
            }
        }

        describe("victory") {
            listOf(
                Choice.ROCK to Choice.SCISSOR,
                Choice.PAPER to Choice.ROCK,
                Choice.SCISSOR to Choice.PAPER
            ).forEach { combination ->
                it("returns victory when I chose ${combination.first} and my enemy ${combination.second} ") {
                    Round(combination.second, combination.first).getResult() shouldBe Result.VICTORY
                }
            }
        }

        describe("defeat") {
            listOf(
                Choice.ROCK to Choice.PAPER,
                Choice.PAPER to Choice.SCISSOR,
                Choice.SCISSOR to Choice.ROCK
            ).forEach { combination ->
                it("returns defeat when I chose ${combination.first} and my enemy ${combination.second} ") {
                    Round(combination.second, combination.first).getResult() shouldBe Result.DEFEAT
                }
            }
        }
    }

    describe("getScore") {
        describe("defeats") {
            it("returns 1 for rock") {
                Round(Choice.PAPER, Choice.ROCK).getScore() shouldBe 1
            }

            it("returns 2 for paper") {
                Round(Choice.SCISSOR, Choice.PAPER).getScore() shouldBe 2
            }

            it("returns 3 for scissor") {
                Round(Choice.ROCK, Choice.SCISSOR).getScore() shouldBe 3
            }
        }

        describe("draws") {
            it("returns 4 for rock") {
                Round(Choice.ROCK, Choice.ROCK).getScore() shouldBe 4
            }

            it("returns 5 for paper") {
                Round(Choice.PAPER, Choice.PAPER).getScore() shouldBe 5
            }

            it("returns 6 for scissor") {
                Round(Choice.SCISSOR, Choice.SCISSOR).getScore() shouldBe 6
            }
        }

        describe("victory") {
            it("returns 7 for rock") {
                Round(Choice.SCISSOR, Choice.ROCK).getScore() shouldBe 7
            }

            it("returns 8 for paper") {
                Round(Choice.ROCK, Choice.PAPER).getScore() shouldBe 8
            }

            it("returns 9 for scissor") {
                Round(Choice.PAPER, Choice.SCISSOR).getScore() shouldBe 9
            }
        }
    }

    describe("from enemies choice and result") {
        describe("draws") {
            Choice.values().forEach {
                it("chooses $it as my choice when enemy chose $it") {
                    val result = Round.fromEnemiesChoiceAndResult(it, Result.DRAW)

                    result shouldBe Round(it, it)
                }
            }
        }

        describe("victories") {
            it("chooses rock if enemy chose scissor") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.SCISSOR, Result.VICTORY)

                result shouldBe Round(Choice.SCISSOR, Choice.ROCK)
            }

            it("chooses scissor if enemy chose paper") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.PAPER, Result.VICTORY)

                result shouldBe Round(Choice.PAPER, Choice.SCISSOR)
            }

            it("chooses paper if enemy chose rock") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.ROCK, Result.VICTORY)

                result shouldBe Round(Choice.ROCK, Choice.PAPER)
            }
        }

        describe("defeat") {
            it("chooses rock if enemy chose paper") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.PAPER, Result.DEFEAT)

                result shouldBe Round(Choice.PAPER, Choice.ROCK)
            }

            it("chooses scissor if enemy chose rock") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.ROCK, Result.DEFEAT)

                result shouldBe Round(Choice.ROCK, Choice.SCISSOR)
            }

            it("chooses paper if enemy chose scissor") {
                val result = Round.fromEnemiesChoiceAndResult(Choice.SCISSOR, Result.DEFEAT)

                result shouldBe Round(Choice.SCISSOR, Choice.PAPER)
            }
        }
    }
})
