package store

import core.RegisterResult
import core.Transaction

class InMemoryTransactionEventsStore : TransactionEventsStore {
    override fun store(event: RegisterResult) {
        TODO("Not yet implemented")
    }

    override fun loadAllTransactions(): Collection<Transaction> {
        TODO("Not yet implemented")
    }

}

interface TransactionEventsStore {
    fun store(event: RegisterResult)
    fun loadAllTransactions(): Collection<Transaction>

}
