package drivers.api

import com.natpryce.hamkrest.and
import com.natpryce.hamkrest.assertion.assertThat
import core.aValidTransaction
import driven.repositories.InMemTransactionEventsRepository
import driver.accountingHttpServer
import io.kotest.core.spec.style.FunSpec
import org.http4k.client.OkHttp
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasBody
import org.http4k.hamkrest.hasStatus
import useCases.UseCaseReadBalance

class RestApiTest : FunSpec({

    context("using a http4k server") {

        val client = OkHttp()


        val store = InMemTransactionEventsRepository()
        val useCaseReadBalance = UseCaseReadBalance(store)
        val server = accountingHttpServer(0, useCaseReadBalance)

        server.start()

        test("request with initial balance for account 1234567890 should be zero") {
            val response = client(Request(GET, "http://localhost:${server.port()}/balance/1234567890"))
            assertThat(response, hasStatus(OK).and(hasBody("{\"value\":0,\"accountId\":\"accountId\"}")))
        }

        test("request with a transaction") {
            useCaseReadBalance.submit(aValidTransaction())

            val response = client(Request(GET, "http://localhost:${server.port()}/balance/1234567890"))
            assertThat(response, hasStatus(OK).and(hasBody("100")))
        }

        //TODO: third test retreive the right balance for a given transaction


        server.stop()
    }
})
