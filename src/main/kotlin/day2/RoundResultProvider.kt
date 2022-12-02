package day2

fun interface RoundResultProvider {
    fun getResult(): Result
}

enum class Result {
    VICTORY,
    DEFEAT,
    DRAW
}