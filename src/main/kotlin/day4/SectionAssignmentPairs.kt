package day4

data class SectionAssignmentPairs(private val assignmentPairs: List<AssignmentPair>) {
    fun countObsoleteAssignmentPairs(): Int {
        return assignmentPairs.count { assignmentPair ->
            assignmentPair.hasObsoleteAssignment()
        }
    }
}