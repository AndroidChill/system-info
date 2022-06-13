package info.zette.com

import info.zette.com.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureSerialization()
        configureMonitoring()
        configureHTTP()
    }.start(wait = true)
}
