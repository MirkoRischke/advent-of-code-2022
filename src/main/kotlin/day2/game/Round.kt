package day2.game

import day2.utils.Ring

data class Round(
    private val enemyChoice: Choice,
    private val myChoice: Choice
) {
    fun getResult(): Result {
        if (myChoice == enemyChoice) return Result.DRAW

        return if (choiceOrder.getElementAfter(myChoice) == enemyChoice) Result.VICTORY
        else Result.DEFEAT
    }

    fun getScore(): Score {
        return myChoice.score + getResult().score
    }

    companion object {

        // a choice always beats the next element in the ring
        private val choiceOrder = Ring(Choice.ROCK, Choice.SCISSOR, Choice.PAPER)

        fun fromEnemiesChoiceAndResult(enemiesChoice: Choice, result: Result): Round {
            return when (result) {
                Result.VICTORY -> Round(enemiesChoice, choiceOrder.getElementBefore(enemiesChoice))
                Result.DEFEAT -> Round(enemiesChoice, choiceOrder.getElementAfter(enemiesChoice))
                Result.DRAW -> Round(enemiesChoice, enemiesChoice)
            }
        }
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
