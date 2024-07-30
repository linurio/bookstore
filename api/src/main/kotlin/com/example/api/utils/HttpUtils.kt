package com.example.api.utils

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val logger: Logger = LoggerFactory.getLogger("UserController")

data class ErrorResponse(
    val status: HttpStatusCode = HttpStatusCode.InternalServerError,
    val msg: String = "An error occurred ;("
)

suspend fun ApplicationCall.safeCall(
    action: suspend ApplicationCall.() -> Unit,
    onError: ErrorResponse
) {
    try {
        action()
    } catch (err: Exception) {
        logger.error("Error: ", err)
        respond(onError.status, onError.msg)
    }
}
