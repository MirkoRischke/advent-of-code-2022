package day4

data class Assignment(val startSection: CampSection, val endSection: CampSection) {
    fun contains(otherAssignment: Assignment): Boolean {
        return otherAssignment.startSection >= this.startSection &&
                otherAssignment.endSection <= this.endSection
    }

    companion object {
        fun fromString(string: String): Assignment {
            val sections = string.split('-')
            return Assignment(
                sections[0].toInt(),
                sections[1].toInt()
            )
        }
    }
}

typealias CampSection = Int