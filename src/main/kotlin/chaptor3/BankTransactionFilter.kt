package chaptor3

fun interface BankTransactionFilter {
    fun test(bankTransaction: BankTransaction): Boolean
}