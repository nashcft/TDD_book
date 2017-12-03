package money

sealed class Money(private val amount: Int) {

    abstract val currency: String

    fun times(mul: Int): Money {
        return when(this) {
            is Dollar -> dollar(amount * mul)
            is Franc -> franc(amount * mul)
        }
    }

    companion object {
        fun dollar(amount: Int): Money = Money.Dollar(amount)
        fun franc(amount: Int): Money = Money.Franc(amount)
    }

    data class Dollar(private val a: Int, override val currency: String = "USD") : Money(a)
    data class Franc(private val a: Int, override val currency: String = "CHF") : Money(a)
}