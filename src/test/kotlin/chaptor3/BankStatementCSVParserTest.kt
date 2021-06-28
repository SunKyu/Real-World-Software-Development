package chaptor3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate
import java.time.Month

internal class BankStatementCSVParserTest {
    val statementParser = BankStatementCSVParser()

    @Test
    fun `Should parse one correct line`() {
        val line = "30-01-2017,-50,Tesco"

        val result = statementParser.parseFrom(line)

        val expected = BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50.0, "Tesco")
        val tolerance = 0.0

        assertEquals(expected.date, result.date)
        assertEquals(expected.amount, result.amount, tolerance)
        assertEquals(expected.desc, result.desc)


    }

    @Test
    fun parseLinesFrom() {
    }
}