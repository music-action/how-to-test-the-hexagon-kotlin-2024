package repositories

import core.RegisterResult
import core.Transaction

class PostgresTransactionEventsRepository : ITransactionEventsRepository {
    override fun store(event: RegisterResult) {
        TODO("Not yet implemented")
    }

    override fun loadAllTransactions(): Collection<Transaction> {
        TODO("Not yet implemented")
    }
}