package money

import money.Money.Currency

class Bank {

    private val rates: MutableMap<Pair<Currency, Currency>, Int> = HashMap()

    fun reduce(source: Expression, to: Currency) = when (source) {
        is Money -> Money(source.amount / rate(source.currency, to), to)
        is Expression.Sum -> Money(sum(source.augend, source.addend, to), to)
    }

    fun rate(from: Currency, to: Currency) =
            if (from == to) 1 else rates[Pair(from, to)]
                    ?: throw IllegalArgumentException("Unregistered rate: $from to $to")

    private fun sum(augend: Expression, addend: Expression, to: Currency): Int =
            reduce(augend, to).amount + reduce(addend, to).amount

    fun addRate(from: Currency, to: Currency, rate: Int) {
        rates.put(Pair(from, to), rate)
    }
}