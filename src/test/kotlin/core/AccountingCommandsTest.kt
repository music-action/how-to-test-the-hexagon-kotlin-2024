package core

import arrow.core.Either
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class AccountingCommandsTest  : FunSpec({
    /* TODO: property test, round trip Command Valid => Json Valid  */
    /* Json Invalid => Nothing */

    test("command valid transaction") {

        val command = RegisterTransaction(aValidTransaction())
        val sut = Accounting()

      sut.HandleCommand(command = command) shouldBe Either.Right( RegisterResult.TransactionAccepted)
    }

})

