package chaptor4

import java.io.File
import java.io.IOException
import java.util.function.Predicate




class LetterImporter(): Importer {
    private val NAME_PREFIX = "Dear "
    @Throws(IOException::class)
    override fun importFile(file: File): Document {
        val textFile = TextFile(file)

        textFile.addLineSuffix(NAME_PREFIX, PATIENT)

        val lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS)
        textFile.addLines(
            lineNumber + 1,
            { line: String -> line.startsWith("regards,") }, BODY
        )

        val attributes = textFile.attributes
        attributes[TYPE] = "LETTER"
        return Document(attributes)


    }
}