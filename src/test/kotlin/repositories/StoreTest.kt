package repositories

import core.RegisterResult
import core.aValidTransaction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class StoreTest : FunSpec({

    test("load no transaction") {
        val sut = InMemTransactionEventsRepository( )
        //  act
        val listOfTransaction = sut.loadAllTransactions()
        //  assert
        listOfTransaction shouldHaveSize 0
    }

    test("store and load a transactions ") {
        val sut = InMemTransactionEventsRepository( )
        val transaction = aValidTransaction()
        val event = RegisterResult.TransactionAccepted(transaction)
        sut.store(event)
        //  act
        val listOfTransaction = sut.loadAllTransactions()
        //  assert
        listOfTransaction shouldContain ( transaction)
    }
})