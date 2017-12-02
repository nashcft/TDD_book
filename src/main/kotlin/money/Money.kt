package money

sealed class Money(private val amount: Int) {

    fun times(mul: Int): Money {
        return when(this) {
            is Dollar -> Dollar(amount * mul)
            is Franc -> Franc(amount * mul)
        }
    }

    data class Dollar(private val a: Int) : Money(a)
    data class Franc(private val a: Int) : Money(a)
}