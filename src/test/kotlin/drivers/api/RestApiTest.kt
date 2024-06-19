package drivers.api

import org.http4k.client.OkHttp
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
//import org.http4k.hamkrest.hasStatus
import driver.AccountingHttpServer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RestApiTest : FunSpec({

    context("using a http4k server") {

         val client = OkHttp()
         val server = AccountingHttpServer(0)

        server.start()

        test("first request") {
            val response = client(Request(GET, "http://localhost:${server.port()}/ping"))
            response.status shouldBe OK
        }

        server.stop()
    }
})
