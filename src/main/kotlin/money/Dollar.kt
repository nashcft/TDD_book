package money

data class Dollar(private val amount: Int) {

    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }
}
