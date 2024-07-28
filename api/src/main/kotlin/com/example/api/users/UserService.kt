package com.example.api.users

import com.example.api.users.dto.CreateUserDto
import com.example.api.users.dto.UpdateUserDto
import com.example.api.users.dto.UserDto
import com.example.api.users.entities.User
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

class UserService(database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
        }
    }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    suspend fun create(data: CreateUserDto): Int {
        return dbQuery {
            val user = User.new {
                firstName = data.firstName
                lastName = data.lastName
                email = data.email
                passwordHash = ""
                isActivated = false
                avatarUrl = data.avatarUrl
                createdAt = LocalDateTime.now()
                updatedAt = LocalDateTime.now()
            }

            user.id.value
        }
    }

    suspend fun read(id: Int): models.User? {
        return dbQuery {
            User.findById(id)?.toModel()
        }
    }

    suspend fun readAll(): List<models.User> {
        return dbQuery {
            User.all().map { it.toModel() }.toList()
        }
    }

    suspend fun update(id: Int, dto: UpdateUserDto): models.User? {
        return dbQuery {
            Users.update({ Users.id eq id }) {
                dto.firstName?.let { newFirstName ->
                    println(newFirstName)
                    it[firstName] = newFirstName
                }
                dto.lastName?.let { newLastName ->
                    it[lastName] = newLastName
                }
                dto.passwordHash?.let { newPasswordHash ->
                    it[passwordHash] = newPasswordHash
                }
                dto.avatarUrl?.let { newAvatarUrl ->
                    it[avatarUrl] = newAvatarUrl
                }
                dto.isActivated?.let { newIsActivated ->
                    it[isActivated] = newIsActivated
                }

                it[updatedAt] = LocalDateTime.now()
            }

            User.findById(id)?.toModel()
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            User.findById(id)?.delete()
        }
    }
}