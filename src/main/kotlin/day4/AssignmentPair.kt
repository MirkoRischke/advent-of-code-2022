package day4

data class AssignmentPair(private val assignment1: Assignment, private val assignment2: Assignment) {

    fun hasObsoleteAssignment(): Boolean {
        return assignment1.contains(assignment2) || assignment2.contains(assignment1)
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