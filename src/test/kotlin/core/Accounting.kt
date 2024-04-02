package core

import arrow.core.Either

class Accounting {
    fun  HandleCommand(command: RegisterTransaction): Either<String , RegisterResult> =
        Either.Right( RegisterResult.TransactionAccepted)
}
