package money

fun reduce(source: Expression, to: String): Money {
    val sum = source as Sum
    return sum.reduce(to)
}