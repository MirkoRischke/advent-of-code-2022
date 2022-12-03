package day2.strategy

import day2.game.Choice
import day2.game.Round

data class StrategyV1(private val enemiesChoice: Column1, private val yourChoice: Column2): Strategy() {
    override fun toRound(): Round {
        val enemiesDecryptedChoice = when(enemiesChoice) {
            Column1.A -> Choice.ROCK
            Column1.B -> Choice.PAPER
            Column1.C -> Choice.SCISSOR
        }

        val yourDecryptedChoice = when(yourChoice) {
            Column2.X -> Choice.ROCK
            Column2.Y -> Choice.PAPER
            Column2.Z -> Choice.SCISSOR
        }
        return Round(enemiesDecryptedChoice, yourDecryptedChoice)
    }

}