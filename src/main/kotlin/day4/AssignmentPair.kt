package day4

data class AssignmentPair(private val assignment1: Assignment, private val assignment2: Assignment) {

    fun hasObsoleteAssignment(): Boolean {
        return assignment1.contains(assignment2) || assignment2.contains(assignment1)
    }

    fun hasOverlappingSections(): Boolean {
        val assignment2StartsWithinAssignment1 =
            assignment2.startSection >= assignment1.startSection && assignment2.startSection <= assignment1.endSection
        val assignment2EndsWithinAssignment1 =
            assignment2.endSection >= assignment1.startSection && assignment2.endSection <= assignment1.endSection
        return assignment2StartsWithinAssignment1 ||
            assignment2EndsWithinAssignment1 ||
            assignment2.contains(assignment1)
    }

    companion object {
        fun fromString(string: String): AssignmentPair {
            val assignments = string.split(',')

            return AssignmentPair(
                Assignment.fromString(assignments[0]),
                Assignment.fromString(assignments[1])
            )
        }
    }
}
