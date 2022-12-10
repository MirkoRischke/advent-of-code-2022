package day4

data class Assignment(val startSection: CampSection, val endSection: CampSection) {
    fun contains(otherAssignment: Assignment): Boolean {
        return otherAssignment.startSection >= this.startSection &&
                otherAssignment.endSection <= this.endSection
    }
}

typealias CampSection = Int