package day2

data class Strategy(private val enemiesChoice: EnemiesEncryptedChoice, private val yourChoice: YourEncryptedChoice) {
    fun toRound(): Round {
        val enemiesDecryptedChoice = when(enemiesChoice) {
            EnemiesEncryptedChoice.A -> Choice.ROCK
            EnemiesEncryptedChoice.B -> Choice.PAPER
            EnemiesEncryptedChoice.C -> Choice.SCISSOR
        }

        val yourDecryptedChoice = when(yourChoice) {
            YourEncryptedChoice.X -> Choice.ROCK
            YourEncryptedChoice.Y -> Choice.PAPER
            YourEncryptedChoice.Z -> Choice.SCISSOR
        }
        return Round(enemiesDecryptedChoice, yourDecryptedChoice)
    }

}

enum class EnemiesEncryptedChoice {
    A,
    B,
    C
}

enum class YourEncryptedChoice {
    X,
    Y,
    Z,
}
