package money

fun reduce(source: Expression, to: String) = when (source) {
    is Money -> source
    is Expression.Sum -> Money(sum(source.augend, source.addend, to), to)
}

private fun sum(augend: Expression, addend: Expression, to: String): Int =
        reduce(augend, to).amount + reduce(addend, to).amount
