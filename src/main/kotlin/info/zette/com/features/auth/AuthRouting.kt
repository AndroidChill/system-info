package info.zette.com.features.auth

import info.zette.com.features.auth.controller.LoginController
import info.zette.com.features.auth.controller.RegisterController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureAuthRouting() {

    routing {
        post("/register") {
            val registerController = RegisterController(call)
            registerController.registerNewUser()
        }
        post("/login") {
            val loginController = LoginController(call)
            loginController.performLogin()
        }
    }
}