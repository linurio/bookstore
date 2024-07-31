package com.example.api.storage

import io.github.cdimascio.dotenv.dotenv
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database


class DatabaseService {
    private val dbHost: String = dotenv().get("DB_HOST") ?: System.getenv("DB_HOST")
    private val dbPort: String = dotenv().get("DB_PORT") ?: System.getenv("DB_PORT")
    private val dbName: String = dotenv().get("DB_NAME") ?: System.getenv("DB_NAME")
    private val dbUser: String = dotenv().get("DB_USER") ?: System.getenv("DB_USER")
    private val dbPass: String = dotenv().get("DB_PASS") ?: System.getenv("DB_PASS")

    val database: Database = connect()

    private fun connect(): Database {
        printConfig()

        return Database.connect(
            "jdbc:postgresql://$dbHost:$dbPort/$dbName",
            driver = "org.postgresql.Driver",
            user = dbUser,
            password = dbPass
        )
    }

    fun migrate() {
        val flyway = Flyway.configure()
            .dataSource(
                "jdbc:postgresql://${dbHost}:${dbPort}/${dbName}",
                dbUser,
                dbPass
            )
            .baselineOnMigrate(true)
            .load()

        flyway.migrate()
    }

    private fun printConfig() {
        println(
            """
            | Database Configuration:
            | Host: $dbHost
            | Port: $dbPort
            | Name: $dbName
            | User: $dbUser
            | Pass: $dbPass
        """.trimMargin()
        )
    }
}