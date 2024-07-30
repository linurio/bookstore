package com.example.api.users

import com.example.api.users.dto.CreateUserDto
import com.example.api.users.dto.UpdateUserDto
import com.example.api.users.entities.User
import com.example.api.utils.dbQuery
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

class UserService(database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
        }
    }

    suspend fun create(data: CreateUserDto): models.User {
        return dbQuery {
            User.new {
                firstName = data.firstName
                lastName = data.lastName
                email = data.email
                passwordHash = data.password
                isActivated = false
                avatarUrl = data.avatarUrl
                createdAt = LocalDateTime.now()
                updatedAt = LocalDateTime.now()
            }.toModel()
        }
    }

    suspend fun read(id: Int): models.User? {
        return dbQuery {
            User.findById(id)?.toModel()
        }
    }

    suspend fun findByEmail(email: String): models.User? {
        return dbQuery {
            User.find { Users.email eq email }.singleOrNull()?.toModel()
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
                dto.refreshToken?.let { newRefreshToken ->
                    it[refreshToken] = newRefreshToken
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