package day2

data class StrategyV2(private val enemiesChoice: Column1, private val roundResult: Column2): Strategy() {
    override fun toRound(): Round {
        val enemiesDecryptedChoice = when(enemiesChoice) {
            Column1.A -> Choice.ROCK
            Column1.B -> Choice.PAPER
            Column1.C -> Choice.SCISSOR
        }

        val result = when(roundResult) {
            Column2.X -> Result.DEFEAT
            Column2.Y -> Result.DRAW
            Column2.Z -> Result.VICTORY
        }
        return Round.fromEnemiesChoiceAndResult(enemiesDecryptedChoice, result)
    }

}