package core

import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
@AutoScan()
class BalanceTest : FunSpec( {

    test("balance") {
         // arrange

        val sut = Balance()

        sut.adjust(aValidTransaction())

        sut.account("1234567890") shouldBe Movement.Credit(100)
        sut.account("1234567891") shouldBe Movement.Debit(100)
    }

    test("adjust balance with another transaction") {
        // arrange

        val sut = Balance()

        sut.adjust(aValidTransaction())
        sut.adjust(anotherValidTransaction())

        sut.account("1234567891") shouldBe Movement.Debit(200)
    }
})

