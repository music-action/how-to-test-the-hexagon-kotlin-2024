package core

fun aValidTransaction(): Transaction {
    val entries =
        listOf(
            Entry(accountNumber = "1234567890", movement = Movement.Credit(100)),
            Entry(accountNumber = "1234567890", movement = Movement.Debit(100))
        )
    return Transaction(reference = 1, entries = entries, date = "2020-01-01")
}