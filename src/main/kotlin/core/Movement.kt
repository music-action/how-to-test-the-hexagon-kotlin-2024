package core

sealed class Movement(amount: Int) {
    abstract fun value(): Int


    data class Credit(val amount: Int) : Movement(1) {
        override fun value(): Int {
            return amount
        }
    }

    data class Debit(val amount: Int) : Movement(1) {
        override fun value(): Int {
            return  -amount
        }
    }

}
