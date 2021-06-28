package chaptor3

import java.nio.file.Files
import java.nio.file.Paths
import java.time.Month
import java.util.stream.Collectors




class BankStatementAnalyzerSRP {
    private val RESOURCES = "src/main/resources/"

    fun parse(args: Array<String>){
        val bankStatementCSVParser = BankStatementCSVParser();
        val fileName = args[0]
        val path = Paths.get("$RESOURCES$fileName")
        val lines = Files.readAllLines(path)

        val bankTransactions = bankStatementCSVParser.parseLinesFrom(lines)

        println("the total for all transaction is ${calculateTotalAmount(bankTransactions)}")
        println("Transaction in January ${selectInMonth(bankTransactions, Month.JANUARY)}")

    }

    companion object{
        private fun calculateTotalAmount(bankTransactions: List<BankTransaction>): Double{
            return bankTransactions.stream().mapToDouble(BankTransaction::amount).sum();
        }

        private fun selectInMonth(bankTransactions: List<BankTransaction>, month: Month): List<BankTransaction>{
            return bankTransactions.stream()
                .filter{(date) -> month == date.month }
                .collect(Collectors.toList())
        }
    }

}