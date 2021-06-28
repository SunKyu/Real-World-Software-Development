package chaptor3

class Chaptor3Main {

    fun main(args: Array<String>){
        val bankStatementAnalyzer = BankStatementAnalyzer()
        val bankStatementParser = BankStatementCSVParser()
        val exporter = HtmlExporter()

        bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter)

    }
}