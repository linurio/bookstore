package com.example.api.plugins

import com.example.api.auth.AuthService
import com.example.api.storage.DatabaseService
import com.example.api.users.UserService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    val appModule = module {
        single { DatabaseService().database }
        single { UserService(get()) }
        single { AuthService(get()) }
    }

    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}