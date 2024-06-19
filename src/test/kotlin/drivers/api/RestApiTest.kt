package drivers.api

import core.Movement
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiTest : FunSpec( {

    context("this outer block is enabled") {

        val server = MockWebServer()

        val api = Retrofit.Builder()
            .baseUrl(server.url("/balance"))//Pass any base url like this
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AccountingApi::class.java)

        test("our first API call") {
           val response =  api.getBalance()
              server.takeRequest()//let the server take the request

            // assertEquals(data, dto)
        }

        server.shutdown()
    }
})