package money

class Sum(val augend: Money, val addend: Money) : Expression {

    fun reduce(to: String): Money {
        val amount = augend.amount + addend.amount
        return Money(amount, to)
    }
}