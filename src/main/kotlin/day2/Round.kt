package day2

class Round(
    private val myChoice: Choice,
    private val enemyChoice: Choice): RoundResultProvider {

    override fun getResult(): Result {
        return when(myChoice) {
            Choice.ROCK -> when(enemyChoice) {
                Choice.ROCK -> Result.DRAW
                Choice.PAPER -> Result.DEFEAT
                Choice.SCISSOR -> Result.VICTORY
            }
            Choice.PAPER -> when(enemyChoice) {
                Choice.ROCK -> Result.VICTORY
                Choice.PAPER -> Result.DRAW
                Choice.SCISSOR -> Result.DEFEAT
            }
            Choice.SCISSOR -> when(enemyChoice) {
                Choice.ROCK -> Result.DEFEAT
                Choice.PAPER -> Result.VICTORY
                Choice.SCISSOR -> Result.DRAW
            }
        }
    }

}

enum class Choice {
    ROCK,
    PAPER,
    SCISSOR
}

