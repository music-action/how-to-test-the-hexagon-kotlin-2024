package drivers.api

import core.Balance
import retrofit2.http.GET

interface AccountingApi {

    @GET("balance")
    suspend fun getBalance(

    ): Balance
}

//annotation class GET(val value: String)
