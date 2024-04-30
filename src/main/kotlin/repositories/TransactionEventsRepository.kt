package repositories

import core.RegisterResult
import core.Transaction

class TransactionEventsRepository : ITransactionEventsRepository {
    override fun store(event: RegisterResult) {
        TODO("Not yet implemented")
    }

    override fun loadAllTransactions(): Collection<Transaction> {
        TODO("Not yet implemented")
    }

}

