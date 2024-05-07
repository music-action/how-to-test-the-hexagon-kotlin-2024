package useCases

import core.Movement
import core.RegisterResult
import core.Transaction
import core.aValidTransaction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import repositories.TransactionEventsRepository

class useCasesTests : FunSpec( {

    test("trial balance") {
         // arrange
        val store = TransactionEventsRepository( )

        val sut = UseCaseReadBalance(store)

        sut.submit(aValidTransaction())
        sut.submit(anotherValidTransaction() )

        // act
        val trialBalance = sut.readBalance()
        // assert
        trialBalance.account("1234567890") shouldBe Movement.Credit(100)
    }
})

fun anotherValidTransaction(): Transaction {
    TODO("Not yet implemented")
}
