package driver



import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.ServerFilters.CatchLensFailure
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun accountingHttpServer(port: Int): Http4kServer  = accountingHttpHandler().asServer(Jetty(port))

fun accountingHttpHandler(): HttpHandler = CatchLensFailure.then(
    routes(
        "/balance" bind Method.GET to { _: Request -> Response(OK).body("0") }

    )
)