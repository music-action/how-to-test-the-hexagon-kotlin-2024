package useCases

import core.Balance
import core.Ledger
import core.Transaction
import driven.repositories.ITransactionEventsRepository

class UseCaseReadBalance(val store: ITransactionEventsRepository)  {
    val ledger = Ledger()

    fun submit(aTransaction: Transaction) {
      TODO()
    }

    fun readBalance(): Balance {
       TODO()
    }


}
