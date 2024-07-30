package com.example.api

import com.example.api.plugins.configureCors
import com.example.api.plugins.configureJWT
import com.example.api.plugins.configureKoin
import com.example.api.plugins.configureRouting
import com.example.api.plugins.configureSerialization
import io.github.cdimascio.dotenv.Dotenv
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    Dotenv.load()

    embeddedServer(
        Netty,
        port = 4200,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureJWT()
    configureSerialization()
    configureCors()
    configureRouting()
}
