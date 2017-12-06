package money

import money.Money.Companion.dollar
import money.Money.Companion.franc
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = dollar(5)
        assertEquals(dollar(10), five * 2)
        assertEquals(dollar(15), five * 3)
    }

    @Test
    fun testEquality() {
        assertTrue(dollar(5) == dollar(5))
        assertFalse(dollar(5) == dollar(6))

        assertFalse(dollar(5) == franc(5))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", dollar(1).currency)
        assertEquals("CHF", franc(1).currency)
    }

    @Test
    fun testSimpleAddition() {
        val five = dollar(5)
        val sum = five + dollar(5)
        val reduced = Bank().reduce(sum, "USD")
        assertEquals(dollar(10), reduced)
    }

    @Test
    fun testPlusReturnSum() {
        val five = dollar(5)
        val sum = (five + five) as Expression.Sum
        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum = Expression.Sum(dollar(3), dollar(4))
        val result = Bank().reduce(sum, "USD")
        assertEquals(dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        val result = Bank().reduce(dollar(1), "USD")
        assertEquals(dollar(1), result)
    }

    @Test
    fun testReduceMoneyDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(franc(2), "USD")
        assertEquals(dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    private val fiveBucks: Expression = dollar(5)
    private val tenFrancs: Expression = franc(10)

    @Test
    fun testMixedAddition() {
        val bank = setUpBankWithCHF2USDRate()
        val result = bank.reduce(fiveBucks + tenFrancs, "USD")
        assertEquals(dollar(10), result)
    }

    @Test
    fun testSumPlusMoney() {
        val bank = setUpBankWithCHF2USDRate()
        val sum = Expression.Sum(fiveBucks, tenFrancs) + fiveBucks
        val result = bank.reduce(sum, "USD")
        assertEquals(dollar(15), result)
    }

    @Test
    fun testSumTimes() {
        val bank = setUpBankWithCHF2USDRate()
        val sum = Expression.Sum(fiveBucks, tenFrancs) * 2
        val result = bank.reduce(sum, "USD")
        assertEquals(dollar(20), result)
    }

    private fun setUpBankWithCHF2USDRate(): Bank {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        return bank
    }

    @Test
    fun testPlusSameCurrencyReturnMoney() {
        val sum = dollar(1) + dollar(1)
        assertTrue(sum is Money)
    }
}
