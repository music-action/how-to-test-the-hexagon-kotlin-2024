package driver


import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.ServerFilters.CatchLensFailure
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer
import useCases.UseCaseReadBalance

fun accountingHttpServer(port: Int, useCaseReadBalance: UseCaseReadBalance): Http4kServer =
    accountingHttpHandler(useCaseReadBalance).asServer(Jetty(port))

fun accountingHttpHandler(useCaseReadBalance: UseCaseReadBalance): HttpHandler = CatchLensFailure.then(
    routes(
        "/balance/{accountId}" bind Method.GET to { request: Request ->
            val accountId = request.path("accountId")!!
            val balance = useCaseReadBalance.readBalance()
            Response(OK).body(balance.account(accountId).toString())
        }

    )
)