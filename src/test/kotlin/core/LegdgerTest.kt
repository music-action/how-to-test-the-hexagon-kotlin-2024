package core

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

})
