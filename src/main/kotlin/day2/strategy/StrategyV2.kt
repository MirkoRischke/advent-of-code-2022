package day2.strategy

data class StrategyV2(private val enemiesChoice: Column1, private val roundResult: Column2) : Strategy {
    override fun toRound(): day2.game.Round {
        val enemiesDecryptedChoice = when (enemiesChoice) {
            Column1.A -> day2.game.Choice.ROCK
            Column1.B -> day2.game.Choice.PAPER
            Column1.C -> day2.game.Choice.SCISSOR
        }

        val result = when (roundResult) {
            Column2.X -> day2.game.Result.DEFEAT
            Column2.Y -> day2.game.Result.DRAW
            Column2.Z -> day2.game.Result.VICTORY
        }
        return day2.game.Round.fromEnemiesChoiceAndResult(enemiesDecryptedChoice, result)
    }
}
