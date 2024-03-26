package core

import arrow.core.None
import arrow.core.Some
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LedgerTest : FunSpec({

    test("transaction without entries") {
        val sut = Ledger()
        val entries = listOf<Entry>()

        val actual: RegisterResult =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))


        actual shouldBe RegisterResult.TransactionRejected
    }

    test("transaction with two balanced entries") {
        val sut = Ledger()
        val entries =
            listOf(
                Entry(accountNumber = "1234567890", movement = Movement.Credit(100)),
                Entry(accountNumber = "1234567890", movement = Movement.Debit(100))
            )

        val actual =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe RegisterResult.TransactionAccepted
    }

    test("transaction with one unbalanced entries") {
        val sut = Ledger()
        val entries =
            listOf(
                Entry(accountNumber = "1234567890", movement = Movement.Credit(99))
            )

        val actual =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

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

})
