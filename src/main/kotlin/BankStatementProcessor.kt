import java.time.Month

class BankStatementProcessor(
    private val bankTransactions: List<BankTransaction>
) {


    fun summarizeTransactions(): SummaryStatistics {
        val doubleSummaryStatistics = bankTransactions.stream()
            .mapToDouble(BankTransaction::amount)
            .summaryStatistics()
        return SummaryStatistics(doubleSummaryStatistics.sum,
            doubleSummaryStatistics.max,
            doubleSummaryStatistics.min,
            doubleSummaryStatistics.average
        )
    }

    fun summarizeTransactions(bankTransactionSummarizer: BankTransactionSummarizer): Double {
        var result = 0.0
        for (bankTransaction in bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction)
        }
        return result
    }

    fun calculateTotalAmount(): Double{
        var total = 0.0
        for (bankTransaction in bankTransactions){
            total += bankTransaction.amount
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
    fun calculateTotalInMonth(month: Month): Double {

        return summarizeTransactions {acc, bankTransaction ->
            if (bankTransaction.date.month == month) acc + bankTransaction.amount
            else acc
        }
    }
    /*
    fun calculateTotalInMonth(month: Month): Double{
        var total = 0.0
        for (bankTransaction in bankTransactions){
            if (bankTransaction.date.month == month){
                total += bankTransaction.amount
            }
        }
        return total
    }
     */

    fun findTransactionsGreaterThanEqual(amount: Int): List<BankTransaction>{
        return findTransactions { bankTransaction -> bankTransaction.amount >= amount }

    }

    fun findTransactions(bankTransactionFilter: BankTransactionFilter): List<BankTransaction> {
        val result = arrayListOf<BankTransaction>()
        for(bankTransaction in bankTransactions){
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction)
            }
        }
        return result
    }
}