package testutils

import java.nio.file.Path

object ResourceHelper {

    fun pathFor(fileName: String): Path {
        return Path.of(this.javaClass.getResource(fileName)!!.toURI())
    }
}
