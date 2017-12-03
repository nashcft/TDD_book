package money

data class Money(val amount: Int, val currency: String) : Expression() {

    fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

    operator fun plus(addend: Money): Expression = Sum(this, addend)

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}

sealed class Expression {

    data class Sum(val augend: Money, val addend: Money) : Expression()
}
