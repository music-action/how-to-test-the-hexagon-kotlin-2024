package core

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MovementTest : FunSpec( {

    test("movement credit plus credit") {
        Movement.Credit(10) + Movement.Credit(10) shouldBe Movement.Credit(20)
    }

    test("movement debit plus debit") {
        Movement.Debit(10) + Movement.Debit(10) shouldBe Movement.Debit(20)
    }

    test("movement debit plus credit") {
        Movement.Debit(10) + Movement.Credit(15) shouldBe Movement.Credit(5)
    }

})

