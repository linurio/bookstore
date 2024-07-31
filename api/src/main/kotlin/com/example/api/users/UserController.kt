package com.example.api.users

import com.example.api.users.dto.UpdateUserDto
import com.example.api.utils.ErrorResponse
import com.example.api.utils.safeCall
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.usersController() {
    val userService by inject<UserService>()

    route("/users") {
//        post("") {
//            call.safeCall({
//                val user = call.receive<CreateUserDto>()
//                val id = userService.create(user)?.id
//                respond(HttpStatusCode.Created, id)
//            }, ErrorResponse())
//        }
//
        get("") {
            call.safeCall({
                val users = userService.readAll()
                if (users.isNotEmpty()) {
                    respond(HttpStatusCode.OK, users)
                }

                respond(HttpStatusCode.NotFound)
            }, ErrorResponse())
        }

        get("/{id}") {
            call.safeCall({
                val id =
                    call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                val user = userService.read(id)
                if (user != null) {
                    call.respond(HttpStatusCode.OK, user)
                }

                call.respond(HttpStatusCode.NotFound)
            }, ErrorResponse())
        }

        // TODO: fix this shit
        put("/{id}") {
            call.safeCall({
                val id =
                    call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                val user = call.receive<UpdateUserDto>()
                val updatedUser = userService.update(id, user)
                if (updatedUser != null) {
                    call.respond(HttpStatusCode.OK, updatedUser)
                }

                call.respond(HttpStatusCode.NotFound)
            }, ErrorResponse())
        }

        delete("/{id}") {
            call.safeCall({
                val id =
                    call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                userService.delete(id)
                call.respond(HttpStatusCode.OK)
            }, ErrorResponse())
        }
    }
}