package core

import arrow.core.None
import arrow.core.Some
import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
@AutoScan()
class MovementTest : FunSpec( {

    test("movement test, can't create movement with zero amount").config(enabled = true)  {

        val actual = Movement.debit(0)

        actual shouldBe None
    }

    test("actual debit with positive amount").config(enabled = false)  {

        val actual = Movement.debit(45)

        actual shouldBe Some(Movement.Debit(45))
    }

    test("can not create a debit with negative amount").config(enabled = false)  {

        val actual = Movement.debit(-27)

        actual shouldBe None
    }

    test(" can't create credit with zero amount").config(enabled = false)  {

        val actual = Movement.credit(0)

        actual shouldBe None
    }

    test("actual credit with positive amount").config(enabled = false)  {

        val actual = Movement.credit(45)

        actual shouldBe Some(Movement.Credit(45))
    }

    test("can not create a credit with negative amount").config(enabled = false)  {

        val actual = Movement.credit(-27)

        actual shouldBe None
    }

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

