package core

class Ledger {
    fun RegisterTransaction(transaction: Transaction): Boolean {

        return  transaction.entries.isNotEmpty()

    }


}
