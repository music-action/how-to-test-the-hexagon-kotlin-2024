package core

class Ledger {
    fun RegisterTransaction(transaction: Transaction): RegisterResult {

        if  (transaction.entries.count() <2 )
            return RegisterResult.TransactionRejected
        return RegisterResult.TransactionAccepted
    }


}
