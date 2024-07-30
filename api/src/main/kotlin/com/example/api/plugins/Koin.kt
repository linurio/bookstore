package com.example.api.plugins

import com.example.api.auth.AuthService
import com.example.api.users.UserService
import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    val dbHost = dotenv().get("DB_HOST")
    val dbPort = dotenv().get("DB_PORT")
    val dbName = dotenv().get("DB_NAME")
    val dbUser = dotenv().get("DB_USER")
    val dbPass = dotenv().get("DB_PASS")

    println("\n\nhost: $dbHost\t | \tname: $dbName\t | \tport: $dbPort\n\nuser: $dbUser\t | \tpass: $dbPass\n\n")

    val appModule = module {
        single {
            Database.connect(
                "jdbc:postgresql://$dbHost:$dbPort/$dbName",
                driver = "org.postgresql.Driver",
                user = dbUser,
                password = dbPass,
            )
        }
        single { UserService(get()) }
        single { AuthService(get()) }
    }

    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}