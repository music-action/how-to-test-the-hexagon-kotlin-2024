package core

sealed interface RegisterResult {

   data object TransactionRejected : RegisterResult {}

   data class TransactionAccepted(val transaction: Transaction) : RegisterResult {    }
}
