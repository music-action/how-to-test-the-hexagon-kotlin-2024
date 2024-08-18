package useCases

import core.Movement
import core.aValidTransaction
import core.anotherValidTransaction
import driven.repositories.InMemTransactionEventsRepository
import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

@AutoScan()
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

        //   trialBalance.account("") shouldBe Movement.Credit(0)
        //   trialBalance.account("") shouldBe Movement.Debit(00)
    }
})

