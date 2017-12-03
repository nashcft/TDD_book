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
        val sum = five.plus(dollar(5))
        val reduced = reduce(sum, "USD")
        assertEquals(dollar(10), reduced)
    }
}

