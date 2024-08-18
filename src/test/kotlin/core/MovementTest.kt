package core

import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
@AutoScan()
class MovementTest : FunSpec( {

    test("movement credit plus credit") {
        Movement.Credit(10) + Movement.Credit(10) shouldBe Movement.Credit(20)
    }

    test("movement debit plus debit") {
        Movement.Debit(10) + Movement.Debit(10) shouldBe Movement.Debit(20)
    }

    test("movement debit plus credit") {
        Movement.Debit(10) + Movement.Credit(15) shouldBe Movement.Credit(5)
        Movement.Debit(15) + Movement.Credit(10) shouldBe Movement.Debit(5)
    }

    test("movement credit plus debit") {
        Movement.Credit(10) + Movement.Debit(15) shouldBe Movement.Debit(5)
    }

    test("Test pending regarding movement Zero").config(enabled = false) {
        //Movement.Credit(10) + Movement.Debit(10) Movement.Zero()
    }

})

