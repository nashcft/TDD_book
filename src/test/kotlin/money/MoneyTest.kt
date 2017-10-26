package money

import org.junit.Test
import kotlin.test.assertEquals

class MoneyTest {

    @Test fun testMultiplication() {
        val five: Dollar = Dollar(5)
        five.times(2)
        assertEquals(10, five.amount)
    }
}

