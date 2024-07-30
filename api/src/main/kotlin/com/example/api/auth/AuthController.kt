package com.example.api.auth

import com.example.api.auth.dto.LoginUserDto
import com.example.api.auth.dto.RegisterUserDto
import com.example.api.utils.ErrorResponse
import com.example.api.utils.safeCall
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.authController() {

    val authService by inject<AuthService>()

    route("/auth") {
        post("/register") {
            call.safeCall({
                val data = call.receive<RegisterUserDto>()
                val user = authService.register(data)

                respond(HttpStatusCode.Created, user)
            }, ErrorResponse(HttpStatusCode.Unauthorized, "Registration failed"))
        }

        post("/login") {
            call.safeCall({
                val data = call.receive<LoginUserDto>()
                val user = authService.login(data)

                respond(HttpStatusCode.Created, user)
            }, ErrorResponse(HttpStatusCode.Unauthorized, "Invalid credentials"))
        }

    }
}