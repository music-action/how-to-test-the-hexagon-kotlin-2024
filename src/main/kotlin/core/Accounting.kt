package core

import arrow.core.Either

class Accounting {
    fun  HandleCommand(command: RegisterTransaction): Either<String , RegisterResult> {

        val result = Ledger().RegisterTransaction(transaction = command.transaction)

        return when (result) {
             is  RegisterResult.TransactionAccepted   -> Either.Right(result)
            RegisterResult.TransactionRejected -> Either.Left("Error")
        }
    }
}
