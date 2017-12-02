package money

sealed class Money(private val amount: Int) {

    fun currency(): String {
        return when(this) {
            is Dollar -> "USD"
            is Franc -> "CHF"
        }
    }

    fun times(mul: Int): Money {
        return when(this) {
            is Dollar -> Dollar(amount * mul)
            is Franc -> Franc(amount * mul)
        }
    }

    companion object {
        fun dollar(amount: Int): Money = Money.Dollar(amount)
        fun franc(amount: Int): Money = Money.Franc(amount)
    }

    data class Dollar(private val a: Int) : Money(a)
    data class Franc(private val a: Int) : Money(a)
}