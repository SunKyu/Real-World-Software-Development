import java.time.Month

class BankStatementProcessor(
    val bankTransactions: List<BankTransaction>
) {

    fun calculateTotalAmount(): Double{
        var total = 0.0
        for (bankTransaction in bankTransactions){
            total += bankTransaction.amount
        }
        return total
    }

    fun calculateTotalInMonth(month: Month): Double{
        var total = 0.0
        for (bankTransaction in bankTransactions){
            if (bankTransaction.date.month == month){
                total += bankTransaction.amount
            }
        }
        return total
    }

    fun calculateTotalForCategory(category: String): Double{
        var total = 0.0
        for (bankTransaction in bankTransactions){
            if (bankTransaction.desc == category){
                total += bankTransaction.amount
            }
        }
        return total
    }
}