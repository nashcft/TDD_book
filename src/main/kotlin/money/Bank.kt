package money

class Bank {

    private val rates: MutableMap<Pair<String, String>, Int> = HashMap()

    fun reduce(source: Expression, to: String) = when (source) {
        is Money -> Money(source.amount / rate(source.currency, to), to)
        is Expression.Sum -> Money(sum(source.augend, source.addend, to), to)
    }

    fun rate(from: String, to: String) =
            if (from == to) 1 else rates[Pair(from, to)]
                    ?: throw IllegalArgumentException("Unregistered rate: $from to $to")

    private fun sum(augend: Expression, addend: Expression, to: String): Int =
            reduce(augend, to).amount + reduce(addend, to).amount

    fun addRate(from: String, to: String, rate: Int) {
        rates.put(Pair(from, to), rate)
    }
}