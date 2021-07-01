package chaptor4

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.Collections.unmodifiableList

class DocumentManagementSystem {
    private val documents = ArrayList<Document>()
    private val documentsView = unmodifiableList(documents)

    private val extenstionTOImporter = HashMap<String, Importer>()

    init {
        extenstionTOImporter["letter"] = LetterImporter()
        extenstionTOImporter["jpg"] = ImageImporter()
        extenstionTOImporter["invoice"] = InvoiceImporter()
    }

    @Throws(IOException::class)
    fun importFile(path: String) {
        val file = File(path)
        if (!file.exists()) {
            throw FileNotFoundException(path)
        }

        val separatorIndex = path.lastIndexOf('.')

        if (separatorIndex != -1){
            if (separatorIndex == path.length){
                throw UnknownFileTypeException("No extension found For file: " + path);
            }
            val extension = path.substring(separatorIndex + 1)
            val importer = extenstionTOImporter[extension] ?: null
            if (importer == null) {
                throw UnknownFileTypeException("For file: " + path);
            }

            val document = importer.importFile(file)
            documents.add(document)
        } else {
            throw UnknownFileTypeException(path)
        }
    }
    fun contents(): List<Document> {
        return documentsView
    }

    fun search(): List<Document> {
        return listOf()

    }




}