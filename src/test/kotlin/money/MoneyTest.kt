package money

import money.Money.Companion.dollar
import money.Money.Companion.franc
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {

    @Test fun testMultiplication() {
        val five = dollar(5)
        assertEquals(dollar(10), five.times(2))
        assertEquals(dollar(15), five.times(3))
    }

    @Test fun testEquality() {
        assertTrue(dollar(5) == dollar(5),
                "Compare Dollars with the same amount")
        assertFalse(dollar(5) == dollar(6),
                "Compare Dollars with different amount")

        assertTrue(franc(5) == franc(5),
                "Compare Francs with the same amount")
        assertFalse(franc(5) == franc(6),
                "Compare Francs with different amount")

        @Suppress("ReplaceCallWithComparison")
        assertFalse(dollar(5).equals(franc(5)))
    }

    @Test fun testFrancMultiplication() {
        val five = franc(5)
        assertEquals(franc(10), five.times(2))
        assertEquals(franc(15), five.times(3))
    }

    @Test fun testCurrency() {
        assertEquals("USD", dollar(1).currency())
        assertEquals("CHF", franc(1).currency())
    }
}

