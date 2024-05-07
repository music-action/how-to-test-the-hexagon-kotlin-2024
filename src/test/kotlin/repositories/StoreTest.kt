package repositories

import core.RegisterResult
import core.aValidTransaction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain

class StoreTest : FunSpec({
    /* TODO: property test, round trip Command Valid => Json Valid  */
    /* Json Invalid => Nothing */

    test("store and load a transactions ") {
        val sut = TransactionEventsRepository( )
        val transaction = aValidTransaction()
        val event = RegisterResult.TransactionAccepted(transaction)

        //  act
        sut.store(event)
        // act consequently
        val listOfTransaction = sut.loadAllTransactions()
        //  assert
        listOfTransaction shouldContain ( transaction)

    }
})