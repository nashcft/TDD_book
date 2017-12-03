package money

data class Money(val amount: Int, val currency: String) : Expression {

    fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

    fun plus(addend: Money): Expression = Sum(this, addend)

    override fun reduce(to: String): Money = this

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}