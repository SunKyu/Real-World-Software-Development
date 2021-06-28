package chaptor3

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BankStatementCSVParser(): BankStatementParser {

    private val DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy")


    override fun parseFrom(line: String): BankTransaction {
        val columns = line.split(',')

        val date = LocalDate.parse(columns[0], DATE_PATTERN)
        val amount = columns[1].toDouble()
        val desc = columns[2]

        return BankTransaction(date, amount, desc)
    }

    override fun parseLinesFrom(lines: List<String>): List<BankTransaction> {
        val bankTransactions = ArrayList<BankTransaction>()

        for (line in lines){
            bankTransactions.add(parseFrom(line))
        }
        return bankTransactions
    }
}