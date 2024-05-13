package useCases

import core.Balance
import core.Transaction
import drivers.repositories.ITransactionEventsRepository

class UseCaseReadBalance(store: ITransactionEventsRepository)  {
    fun submit(aValidTransaction: Transaction) {
        TODO("Not yet implemented")
    }

    fun readBalance(): Balance {
        TODO("Not yet implemented")
    }


}
