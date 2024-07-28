package com.example.api.plugins

import com.example.api.users.usersController
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/test") {
            call.respondText("Hello World!")
        }

        usersController()
    }
}
