package day4

import java.nio.file.Path
import kotlin.io.path.useLines

data class SectionAssignmentPairs(private val assignmentPairs: List<AssignmentPair>) {
    fun countObsoleteAssignmentPairs(): Int {
        return assignmentPairs.count { assignmentPair ->
            assignmentPair.hasObsoleteAssignment()
        }
    }

    fun countOverlappingAssignmentPairs(): Int {
        return assignmentPairs.count { assignmentPair ->
            assignmentPair.hasOverlappingSections()
        }
    }

    companion object {
        fun fromPath(file: Path): SectionAssignmentPairs {
            val assignmentPairs: List<AssignmentPair> = file.useLines { lines ->
                lines.map { line ->
                    AssignmentPair.fromString(line)
                }.toList()
            }

            return SectionAssignmentPairs(assignmentPairs)
        }
    }
}
