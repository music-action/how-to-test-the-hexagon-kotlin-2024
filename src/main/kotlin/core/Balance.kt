package core

class Balance {
    val bal: HashMap<String, Movement> = HashMap()

    fun account(accountNumber: String): Movement {
        return bal.getOrDefault(accountNumber, Movement.Credit(0))
    }

    fun adjust(transaction: Transaction): Balance {
        for (e in transaction.entries) {
            val movement = bal.getOrDefault(e.accountNumber, Movement.Credit(0))
            bal.put(e.accountNumber, e.movement + movement)
        }
        return this
    }

}
