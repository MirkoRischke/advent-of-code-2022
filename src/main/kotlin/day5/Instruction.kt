package day5

data class Instruction(
    val amount: Int,
    val from: Int,
    val to: Int,
) {
    companion object {
        fun fromLine(line: String): Instruction {
            val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()

            val (amount, from, to) = regex.find(line)!!.destructured
            return Instruction(amount.toInt(), from.toInt(), to.toInt())
        }
    }
}