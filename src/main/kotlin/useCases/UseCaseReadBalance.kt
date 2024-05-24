package useCases

import core.Balance
import core.Ledger
import core.Transaction
import drivers.repositories.ITransactionEventsRepository

class UseCaseReadBalance(val store: ITransactionEventsRepository)  {
    val ledger = Ledger()

    fun submit(aTransaction: Transaction) {
        val result = ledger.RegisterTransaction(aTransaction)
        store.store(result)
    }

    fun readBalance(): Balance {
        val allTransactions = store.loadAllTransactions()
        val balance = Balance()
        allTransactions.fold(balance) { balance , transaction -> balance.adjust(transaction)  }
        return balance
    }


}
