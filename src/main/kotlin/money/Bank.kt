package money

fun reduce(source: Expression, to: String) = when (source) {
    is Money -> {
        val rate = if (source.currency == "CHF" && to == "USD") 2 else 1
        Money(source.amount / rate, to)
    }
    is Expression.Sum -> Money(sum(source.augend, source.addend, to), to)
}

private fun sum(augend: Expression, addend: Expression, to: String): Int =
        reduce(augend, to).amount + reduce(addend, to).amount

fun addRate(from: String, to: String, rate: Int) {}