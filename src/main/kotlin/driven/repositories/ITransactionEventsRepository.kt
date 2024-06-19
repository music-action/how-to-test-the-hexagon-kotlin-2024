package driven.repositories

import core.RegisterResult
import core.Transaction

interface ITransactionEventsRepository {
    fun store(event: RegisterResult)
    fun loadAllTransactions(): Collection<Transaction>
}