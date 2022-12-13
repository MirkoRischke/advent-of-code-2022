package day1

interface ElvesParser {
    fun createElves(lines: Iterable<String>): Iterable<Elf>
}
