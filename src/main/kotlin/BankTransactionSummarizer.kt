fun interface BankTransactionSummarizer {
    fun summarize(accumulator: Double, bankTransaction: BankTransaction): Double
}