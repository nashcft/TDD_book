package money

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
        @Suppress("SENSELESS_COMPARISON")
        assertFalse(Dollar(5) == null,
                "Compare Dollar to null")
    }

    @Test fun testFrancMultiplication() {
        val five = Franc(5)
        assertEquals(Franc(10), five.times(2))
        assertEquals(Franc(15), five.times(3))
    }
}

