import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

class BankTransactionAnalyzerSimple {
    private val RESORUCES = "src/main/resources/"

    fun parse(args: Array<String>){
        val path = Paths.get("$RESORUCES${args[0]}")
        val lines = Files.readAllLines(path)
        var total = 0.0;
        for (line in lines){
            val columns = line.split(',')
            val amount = columns[1].toDouble()
            total += amount
        }
        println("The total for all transactions is $total")
    }
    fun parseMonth(args: Array<String>){
        val path = Paths.get("$RESORUCES${args[0]}")
        val lines = Files.readAllLines(path)
        var total = 0.0;
        val DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        for (line in lines){
            val columns = line.split(',')
            val date = LocalDate.parse(columns[0], DATE_PATTERN)
            if (date.month == Month.JANUARY) {
                val amount = columns[1].toDouble()
                total += amount
            }
        }
        println("The total for all transactions in January is $total")

    }

}