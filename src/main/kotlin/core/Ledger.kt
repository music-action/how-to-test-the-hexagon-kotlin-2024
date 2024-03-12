package core

class Ledger {
    fun RegisterTransaction(transaction: Transaction): RegisterResult {

        if  (transaction.entries.isEmpty())
            return RegisterResult.TransactionRejected
        return RegisterResult.TransactionAccepted
    }


}
