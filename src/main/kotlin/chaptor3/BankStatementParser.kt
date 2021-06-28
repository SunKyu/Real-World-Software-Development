package chaptor3

interface BankStatementParser {
    fun parseFrom(line: String): BankTransaction
    fun parseLinesFrom(lines: List<String>): List<BankTransaction>
}