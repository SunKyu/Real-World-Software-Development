import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Month
import kotlin.jvm.Throws

class BankStatementAnalyzer() {
    private val RESOURCES = "src/main/resources/"

    @Throws(IOException::class)
    fun analyze(fileName: String, bankStatementParser: BankStatementParser) {
        val path = Paths.get("$RESOURCES$fileName")
        val lines = Files.readAllLines(path)

        val bankTransactions = bankStatementParser.parseLinesFrom(lines)
        val bankStatementProcessor = BankStatementProcessor(bankTransactions)

        collectSummary(bankStatementProcessor)

    }

    private fun collectSummary(bankStatementProcessor: BankStatementProcessor){

        println("the total for all transaction is ${bankStatementProcessor.calculateTotalAmount()}")
        println("Transaction in January ${bankStatementProcessor.calculateTotalInMonth(Month.JANUARY)}")
        println("Transaction in January ${bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY)}")
        println("the total salary received is ${bankStatementProcessor.calculateTotalForCategory("Salary")}")
    }
}