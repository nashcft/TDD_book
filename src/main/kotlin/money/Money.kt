package money

data class Money(private val amount: Int, val currency: String) {

    fun times(multiplier: Int): Money = Money(amount * multiplier, currency)

    fun plus(added: Money): Money = Money(amount + added.amount, currency)

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}