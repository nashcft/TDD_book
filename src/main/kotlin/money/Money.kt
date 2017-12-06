package money

data class Money(val amount: Int, val currency: String) : Expression() {

    operator fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}

sealed class Expression {

    operator fun plus(addend: Expression): Expression = Sum(this, addend)

    data class Sum(val augend: Expression, val addend: Expression) : Expression()
}
