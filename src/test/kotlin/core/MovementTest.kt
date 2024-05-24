package core

import core.Movement.Companion.credit
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MovementTest : FunSpec( {

    test("movement credit plus credit") {
        Movement.Credit(10) + Movement.Credit(10) shouldBe Movement.Credit(20)
    }

    test("movement debit plus debit") {
        Movement.Debit(10) + Movement.Debit(10) shouldBe Movement.Debit(20)
    }

})

