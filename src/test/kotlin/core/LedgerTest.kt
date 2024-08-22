package core

import arrow.core.None
import arrow.core.Some
import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

@AutoScan()
class LedgerTest : FunSpec({

    test("01a transaction without entries boolean") {
        val sut = Ledger()
        val entries = listOf<Entry>()

        val actual: Boolean =
            sut.RegisterTransaction0(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe false
    }


    test("01b transaction without entries").config(enabled = false) {
        val sut = Ledger()
        val entries = listOf<Entry>()

        val actual: RegisterResult =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))


        actual shouldBe RegisterResult.TransactionRejected
    }

    test("transaction with two balanced entries").config(enabled = true)   {
        val transaction = aValidTransaction()
        val sut = Ledger()
        val actual =
            sut.RegisterTransaction( transaction)

        actual shouldBe  RegisterResult.TransactionAccepted(transaction)
    }

    test("transaction with one unbalanced entries should be rejected").config(enabled = false)  {
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

    test("transaction with two unbalanced entries").config(enabled = false)  {
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





})
