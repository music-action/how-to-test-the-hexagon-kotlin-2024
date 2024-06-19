package useCases

import core.Movement
import core.aValidTransaction
import core.anotherValidTransaction
import driven.repositories.InMemTransactionEventsRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class useCasesTests : FunSpec( {

    test("trial balance") {
         // arrange
        val store = InMemTransactionEventsRepository( )

        val sut = UseCaseReadBalance(store)

        sut.submit(aValidTransaction())
        sut.submit(anotherValidTransaction() )

        // act
        val trialBalance = sut.readBalance()
        // assert
        trialBalance.account("1234567890") shouldBe Movement.Credit(100)
        trialBalance.account("1234567891") shouldBe Movement.Debit(200)
    }
})

