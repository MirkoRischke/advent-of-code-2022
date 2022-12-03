package day2

data class Strategy(private val enemiesChoice: Column1, private val yourChoice: Column2) {
    fun toRound(): Round {
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
