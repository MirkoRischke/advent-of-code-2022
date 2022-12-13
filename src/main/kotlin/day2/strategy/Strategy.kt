package day2.strategy

import day2.game.Round

interface Strategy {
    fun toRound(): Round
}

enum class Column1 {
    A,
    B,
    C
}

enum class Column2 {
    X,
    Y,
    Z,
}
