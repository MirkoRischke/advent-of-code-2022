package day3

private const val ALPHABET_SIZE = 26

data class Item(val letter: Char) {

    val score: Int
    private val lowerCaseLetters = CharRange('a', 'z')
    private val upperCaseLetters = CharRange('A', 'Z')

    init {
        require(letter.isLetter()) { "Only letters are allowed (a-z,A-Z)" }
        score = calculateScore(letter)
    }

    private fun calculateScore(char: Char): Int {
        return when (char) {
            in lowerCaseLetters -> lowerCaseLetters.indexOf(char) + 1
            in upperCaseLetters -> upperCaseLetters.indexOf(char) + ALPHABET_SIZE + 1
            else -> {
                throw InvalidItemLetter("calculateScore was called with $char which not a letter.")
            }
        }
    }
}

class InvalidItemLetter(override val message: String?) : Exception()
