package com.example.api.plugins

import com.example.api.users.UserService
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.koin.dsl.module

fun Application.configureKoin() {
    val appModule = module {
        single {
            Database.connect(
                "jdbc:postgresql://localhost:5432/",
                driver = "org.postgresql.Driver",
                user = "postgres",
                password = "postgres"
            )
        }
        single { UserService(get()) }
    }

    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}