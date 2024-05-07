package core

import arrow.core.Either
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class AccountingCommandsTest  : FunSpec({
    /* TODO: property test, round trip Command Valid => Json Valid  */
    /* Json Invalid => Nothing */

    test("command valid transaction") {
        var transaction = aValidTransaction()
        val command = RegisterTransaction(transaction)
        val sut = Accounting()

      sut.HandleCommand(command = command) shouldBe Either.Right( RegisterResult.TransactionAccepted(transaction))
    }

    test("command invalid transaction") {
        val entries =
            listOf(
                Entry(accountNumber = "1234567890", movement = Movement.Credit(99))
            )
        val anInvalidTransaction =  Transaction(reference = 1, entries = entries, date = "2020-01-01")
        val command = RegisterTransaction(anInvalidTransaction     )
        val sut = Accounting()

        sut.HandleCommand(command = command) shouldBe Either.Left("Error")
    }
})

