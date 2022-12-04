package day3

data class Item(private val letter: Char) {

    init {
        if (!letter.isLetter()) {
            throw IllegalArgumentException("Only letters are allowed (a-z,A-Z)")
        }
    }

}
