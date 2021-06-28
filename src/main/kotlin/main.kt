import chaptor3.BankStatementAnalyzer
import chaptor3.BankStatementCSVParser
import chaptor3.HtmlExporter

fun main(args: Array<String>) {
    val bankStatementAnalyzer = BankStatementAnalyzer()
    val bankStatementParser = BankStatementCSVParser()
    val exporter = HtmlExporter()

    bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter)
}