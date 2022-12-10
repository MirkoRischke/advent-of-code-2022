package day5

class SupplyStorage(private val stacks: List<Stack>) {
    fun getStack(position: Int): Stack {
        return stacks[position - 1]
    }

    fun moveCrate(from: Int, to: Int) {
        val crate = getStack(from).removeCrate()

        getStack(to).addCrate(crate)
    }

    fun moveCrates(from: Int, to: Int, amount: Int) {
        repeat(amount) {
            moveCrate(from, to)
        }
    }
}