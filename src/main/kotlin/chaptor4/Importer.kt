package chaptor4

import java.io.File
import java.io.IOException

interface Importer {
    @Throws(IOException::class)
    fun importFile(file: File): Document

}