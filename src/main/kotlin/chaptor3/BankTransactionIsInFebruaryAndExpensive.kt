package chaptor3

import java.time.Month

class BankTransactionIsInFebruaryAndExpensive: BankTransactionFilter {
    override fun test(bankTransaction: BankTransaction): Boolean {
        return bankTransaction.date.month == Month.FEBRUARY && bankTransaction.amount >= 1_000
    }
}