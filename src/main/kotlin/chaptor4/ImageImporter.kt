package chaptor4

import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

class ImageImporter():Importer {
    @Throws(IOException::class)
    override fun importFile(file: File): Document {
        val attributes: HashMap<String, String> = hashMapOf()
        attributes[PATH] = file.path
        val image = ImageIO.read(file)
        attributes[WIDTH] = image.width.toString()
        attributes[HEIGHT] = image.height.toString()
        attributes[TYPE] = "IMAGE"

        return Document(attributes)
    }

}