package day2

data class Round(
    private val enemyChoice: Choice,
    private val myChoice: Choice
) {
    fun getResult(): Result {
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

    fun getScore(): Score {
        return myChoice.score + getResult().score
    }

}

typealias Score = Int

enum class Choice(val score: Score) {
    ROCK(1),
    PAPER(2),
    SCISSOR(3),
}

enum class Result(val score: Score) {
    VICTORY(6),
    DEFEAT(0),
    DRAW(3),
}
