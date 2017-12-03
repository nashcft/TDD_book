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
        val reduced = reduce(sum, "USD")
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
        val result = reduce(sum, "USD")
        assertEquals(dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        val result = reduce(dollar(1), "USD")
        assertEquals(dollar(1), result)
    }
}
