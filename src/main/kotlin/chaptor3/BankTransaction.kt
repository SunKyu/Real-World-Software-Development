package chaptor3

import java.time.LocalDate

data class BankTransaction(
    val date: LocalDate,
    val amount: Double,
    val desc: String) {

    /*
    @Override
    fun equals(o: Any?): Boolean{
        if (this == o) return true
        if (o == null || this.javaClass != o::javaClass) return false
        val that: chaptor3.BankTransaction = o
        return that.amount == amount && date.equals(that.date) && desc.equals(that.desc)
    }
     */
}
