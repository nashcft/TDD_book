package money

data class Money(val amount: Int, val currency: Currency) : Expression() {

    companion object {
        fun dollar(amount: Int) = Money(amount, Currency.USD)
        fun franc(amount: Int) = Money(amount, Currency.CHF)
    }

    enum class Currency {
        USD, CHF
    }
}

sealed class Expression {

    operator fun plus(addend: Expression): Expression = Sum(this, addend)

    operator fun times(multiplier: Int): Expression = when (this) {
        is Money -> Money(amount * multiplier, currency)
        is Sum -> Sum(augend * multiplier, addend * multiplier)
    }

    data class Sum(val augend: Expression, val addend: Expression) : Expression()
}
