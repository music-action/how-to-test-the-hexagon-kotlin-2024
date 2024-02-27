package draft

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LegdgerTest : FunSpec({

    beforeTest {
    }

    afterTest { (testCase, result) ->
    }

    //
    test("transaction without entries") {
        val sut = Ledger()
        val entries = listOf<Entry2>()

        val actual: Boolean =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe false
    }

    test("transaction with two balanced entries") {
        val sut = Ledger()
        val entries =
            listOf(
                Entry2(accountNumber = "1234567890", movement = Movement.Credit(100)),
                Entry2(accountNumber = "1234567890", movement = Movement.Debit(100))
            )

        val actual: Boolean =
            sut.RegisterTransaction(Transaction(reference = 1, entries = entries, date = "2020-01-01"))

        actual shouldBe true
    }

})
