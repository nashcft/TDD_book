package money

import money.Money.Dollar
import money.Money.Franc
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {

    @Test fun testMultiplication() {
        val five = Dollar(5)
        assertEquals(Dollar(10), five.times(2))
        assertEquals(Dollar(15), five.times(3))
    }

    @Test fun testEquality() {
        assertTrue(Dollar(5) == Dollar(5),
                "Compare Dollars with the same amount")
        assertFalse(Dollar(5) == Dollar(6),
                "Compare Dollars with different amount")

        assertTrue(Franc(5) == Franc(5),
                "Compare Francs with the same amount")
        assertFalse(Franc(5) == Franc(6),
                "Compare Francs with different amount")

        @Suppress("ReplaceCallWithComparison")
        assertFalse(Dollar(5).equals(Franc(5)))
    }

    @Test fun testFrancMultiplication() {
        val five = Franc(5)
        assertEquals(Franc(10), five.times(2))
        assertEquals(Franc(15), five.times(3))
    }
}

