package core

import arrow.core.None
import arrow.core.Some
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

class LedgerTest : FunSpec({

    test("transaction without entries") {
        val sut = Ledger()
        val entries = listOf<Entry>()

        val actual: RegisterResult =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))


        actual shouldBe RegisterResult.TransactionRejected
    }

    test("transaction with two balanced entries") {
        val transaction = aValidTransaction()
        val sut = Ledger()
        val actual =
            sut.RegisterTransaction( transaction)

        actual shouldBe  RegisterResult.TransactionAccepted(transaction)
    }

    test("transaction with one unbalanced entries") {
        val sut = Ledger()
        val entries =
            listOf(
                Entry(accountNumber = "1234567890", movement = Movement.Credit(99))
            )

        val actual =
            sut.RegisterTransaction(
                Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe RegisterResult.TransactionRejected
    }

    test("transaction with two unbalanced entries") {
        val sut = Ledger()
        val entries =
            listOf(
                Entry(accountNumber = "1234567890", movement = Movement.Credit(99)),
                Entry(accountNumber = "1234567890", movement = Movement.Debit(100))
            )

        val actual =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe RegisterResult.TransactionRejected
    }

    test("movement test, can't create movement with zero amount") {

        val actual = Movement.debit(0)

        actual shouldBe None
    }

    test("actual debit with positive amount") {

        val actual = Movement.debit(45)

        actual shouldBe Some(Movement.Debit(45))
    }

    test("can not create a debit with negative amount") {

        val actual = Movement.debit(-27)

        actual shouldBe None
    }

    test(" can't create credit with zero amount") {

        val actual = Movement.credit(0)

        actual shouldBe None
    }

    test("actual credit with positive amount") {

        val actual = Movement.credit(45)

        actual shouldBe Some(Movement.Credit(45))
    }

    test("can not create a credit with negative amount") {

        val actual = Movement.credit(-27)

        actual shouldBe None
    }

    /* TODO: implement two adapters for the present hexagon, at least one driven and one driver */
    /* WIP: Input */

    /* TODO: 2nd iteration with property base testing */


    /* TODO: walking skeleton */
    /* TODO: how to timestamp transaction and test it? Fake clock, Fake calendar */
    /* https://verraes.net/2022/03/multi-temporal-events/ */

})
