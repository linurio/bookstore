package com.example.api.users

import com.example.api.users.dto.CreateUserDto
import com.example.api.users.dto.UpdateUserDto
import com.example.api.utils.safeCall
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.usersController() {
    val userService by inject<UserService>()

    route("/users") {
        post("") {
            call.safeCall {
                val user = call.receive<CreateUserDto>()
                val id = userService.create(user)
                respond(HttpStatusCode.Created, id)
            }
        }

        get("/") {
            call.safeCall {
                val users = userService.readAll()
                if (users.isNotEmpty()) {
                    respond(HttpStatusCode.OK, users)
                }

                respond(HttpStatusCode.NotFound)
            }
        }

        get("/{id}") {
            call.safeCall {
                val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                val user = userService.read(id)
                if (user != null) {
                    call.respond(HttpStatusCode.OK, user)
                }

                call.respond(HttpStatusCode.NotFound)
            }
        }

        // TODO: fix this shit
        put("/{id}") {
            call.safeCall {
                val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                val user = call.receive<UpdateUserDto>()
                val updatedUser = userService.update(id, user)
                if (updatedUser != null) {
                    call.respond(HttpStatusCode.OK, updatedUser)
                }

                call.respond(HttpStatusCode.NotFound)
            }
        }

        delete("/{id}") {
            call.safeCall {
                val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                userService.delete(id)
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}