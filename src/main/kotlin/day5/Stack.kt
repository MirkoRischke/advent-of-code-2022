package day5

class Stack(crates: List<Crate> = emptyList()) {

    private val crates = mutableListOf<Crate>()

    init {
        this.crates.addAll(crates)
    }

    val topCrate: Crate
        get() {
            return crates.last()
        }

    fun addCrate(crate: Crate) {
        crates.add(crate)
    }

    fun removeCrate(): Crate {
        return crates.removeLast()
    }
}

typealias Crate = String
