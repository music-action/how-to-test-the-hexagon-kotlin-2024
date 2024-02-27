package draft

sealed class Movement(amount: Int) {
    data class Credit(val amount: Int) : Movement(1)

    data class Debit(val amount: Int) : Movement(1)

}
