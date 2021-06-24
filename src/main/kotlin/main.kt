import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val bankStatementAnalyzer = BankStatementAnalyzer()
    val bankStatementParser = BankStatementCSVParser()
    val exporter = HtmlExporter()

    bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter)
}