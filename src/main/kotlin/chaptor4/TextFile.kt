package chaptor4

import java.io.File
import java.nio.file.Files
import java.util.function.Predicate
import java.util.stream.Collectors.toList

class TextFile(
    file: File
) {
    val attributes: HashMap<String, String> = hashMapOf()
    lateinit var lines: List<String>
    init {
        attributes[PATH] = file.path
        lines = Files.lines(file.toPath()).collect(toList())
    }
    fun addLines(
        start:Int,
        isEnd: Predicate<String>,
        attributeName: String
    ): Int{
        val accumulator = StringBuilder()
        var lineNumber: Int = start
        while (lineNumber < lines.size){
            val line = lines[lineNumber]
            if (isEnd.test(line)){
                break
            }
            accumulator.append(line)
            accumulator.append("\n")
            lineNumber++
        }
        attributes[attributeName] = accumulator.toString().trim()
        return lineNumber
    }

    fun addLineSuffix(prefix: String, attributeName: String?) {
        for (line in lines) {
            if (line.startsWith(prefix)) {
                attributes[attributeName!!] = line.substring(prefix.length)
                break
            }
        }
    }
}