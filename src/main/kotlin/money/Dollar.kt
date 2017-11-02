package money

class Dollar(val amount: Int) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        val dollar: Dollar = other as Dollar
        return amount == dollar.amount
    }
}
