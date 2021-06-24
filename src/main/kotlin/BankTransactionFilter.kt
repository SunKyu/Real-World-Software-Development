fun interface BankTransactionFilter {
    fun test(bankTransaction: BankTransaction): Boolean
}