package repositories

import core.RegisterResult
import core.Transaction

class TransactionEventsRepository : ITransactionEventsRepository {

    val listOfTransactions = mutableListOf<RegisterResult>()

    override fun store(event: RegisterResult) {
      listOfTransactions.add(event)
    }

    override fun loadAllTransactions(): Collection<Transaction> {
       return  listOfTransactions.filterIsInstance<RegisterResult.TransactionAccepted>().map { it.transaction }
    }

}

