package day3

data class Item(val letter: Char) {

    val score: Int
    private val lowerCaseLetters = CharRange('a', 'z')
    private val upperCaseLetters = CharRange('A', 'Z')

    init {
        if (!letter.isLetter()) {
            throw IllegalArgumentException("Only letters are allowed (a-z,A-Z)")
        }
        score = calculateScore(letter)
    }

    private fun calculateScore(char: Char): Int {
        return when(char) {
            in lowerCaseLetters -> lowerCaseLetters.indexOf(char) + 1
            in upperCaseLetters -> upperCaseLetters.indexOf(char) + 27
            else -> {
                throw Error("calculateScore was called with a char that is not a letter. This should not happen.")
            }
        }
    }
}
