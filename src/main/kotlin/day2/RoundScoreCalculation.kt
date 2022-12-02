package day2

class RoundScoreCalculation(
) {

    private val choiceValues: Map<Choice, Score> = mapOf(
        Choice.ROCK to 1,
        Choice.PAPER to 2,
        Choice.SCISSOR to 3,
    )

    private val resultValues: Map<Result, Score> = mapOf(
        Result.VICTORY to 6,
        Result.DRAW to 3,
        Result.DEFEAT to 0,
    )

    fun getScore(myChoice: Choice, roundResultProvider: RoundResultProvider): Score {
        val roundResult = roundResultProvider.getResult()
        return choiceValues[myChoice]!! + resultValues[roundResult]!!
    }

}

typealias Score = Int