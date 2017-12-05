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
        assertEquals(dollar(10), five.times(2))
        assertEquals(dollar(15), five.times(3))
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
}
