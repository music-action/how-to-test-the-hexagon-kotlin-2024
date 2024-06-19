package driver



import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.I_M_A_TEAPOT
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun AccountingHttpServer(port: Int): Http4kServer =
    { _: Request -> Response(I_M_A_TEAPOT) }.asServer(Jetty(port))