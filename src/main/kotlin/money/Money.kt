package money

sealed class Money(private val amount: Int, val currency: String) {

    fun times(multiplier: Int): Money = when (this) {
        is Dollar -> Money.Dollar(amount * multiplier, currency)
        is Franc -> Money.Franc(amount * multiplier, currency)
    }

    companion object {
        fun dollar(amount: Int): Money = Money.Dollar(amount, "USD")
        fun franc(amount: Int): Money = Money.Franc(amount, "CHF")
    }

    data class Dollar(private val a: Int, private val c: String) : Money(a, c)
    data class Franc(private val a: Int, private val c: String) : Money(a, c)
}