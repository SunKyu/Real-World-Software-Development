package chaptor4

import java.io.File
import java.io.IOException


class InvoiceImporter : Importer {
    private val NAME_PREFIX = "Dear "
    private val AMOUNT_PREFIX = "Amount: "

    @Throws(IOException::class)
    override fun importFile(file: File): Document {
        val textFile = TextFile(file)
        textFile.addLineSuffix(NAME_PREFIX, PATIENT)
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT)
        val attributes: MutableMap<String, String> = textFile.attributes
        attributes[TYPE] = "INVOICE"
        return Document(attributes)
    }

}
