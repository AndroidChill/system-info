package info.zette.com

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import info.zette.com.features.auth.configureAuthRouting
import info.zette.com.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database


fun main() {
    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    val port: String = System.getenv("PORT") ?: "8080"

    embeddedServer(Netty, port = port.toInt()) {
        configureRouting()
        configureSerialization()
        configureMonitoring()
        configureAuthRouting()
        configureHTTP()
    }.start(wait = true)
}
