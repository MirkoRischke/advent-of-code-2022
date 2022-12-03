package day2

abstract class Strategy {
    abstract fun toRound(): Round
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
