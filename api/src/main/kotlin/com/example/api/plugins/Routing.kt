package com.example.api.plugins

import com.example.api.auth.authController
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/test") {
            call.respondText("Hello World!")
        }

        authController()
    }
}
