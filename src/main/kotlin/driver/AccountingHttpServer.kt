package driver


import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.ServerFilters.CatchLensFailure
import org.http4k.lens.Query
import org.http4k.lens.string
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.core.Body
import org.http4k.format.Jackson.auto

//import org.http4k.format.Moshi
// import org.http4k.routing.path
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer
import useCases.UseCaseReadBalance


data class DTOBalance(val value: Int)

fun accountingHttpServer(port: Int, useCaseReadBalance: UseCaseReadBalance): Http4kServer =
    accountingHttpHandler(useCaseReadBalance).asServer(Jetty(port))

fun accountingHttpHandler(useCaseReadBalance: UseCaseReadBalance): HttpHandler = CatchLensFailure.then(
    routes(
        "/balance" bind Method.GET to { request: Request ->
             val accountIdRequest = Query.string().required("accountId")
            val accountId = accountIdRequest(request)
            val balance = useCaseReadBalance.readBalance()


            val dtoBalance = DTOBalance(balance.account(accountId).value())
            val bodyJson = Body.auto<DTOBalance>().toLens()
            dtoBalance.let {
                Response(OK).with( bodyJson of it)
            }

        }

    )
)