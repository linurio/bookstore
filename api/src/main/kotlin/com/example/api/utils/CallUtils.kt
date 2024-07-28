package com.example.api.utils

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val logger: Logger = LoggerFactory.getLogger("UserController")

suspend fun ApplicationCall.safeCall(action: suspend ApplicationCall.() -> Unit) {
    try {
        action()
    } catch (err: Exception) {
        logger.error("Error: ", err)
        respond(HttpStatusCode.InternalServerError, "An error occurred")
    }
}