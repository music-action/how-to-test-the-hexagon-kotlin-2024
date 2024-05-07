package core

class Ledger {
    fun RegisterTransaction(transaction: Transaction): RegisterResult {

        if (transaction.entries.count() < 2)
            return RegisterResult.TransactionRejected
        val balance = transaction.balance()

        if (balance == 0) return RegisterResult.TransactionAccepted(transaction)
        return RegisterResult.TransactionRejected
    }

}
