package com.example.api.users.entities

import com.example.api.users.Users
import com.example.api.users.dto.UserDto
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toIsoString(): String = this.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
fun String.toLocalDateTime(): LocalDateTime = LocalDateTime.parse(this, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var firstName by Users.firstName
    var lastName by Users.lastName
    var email by Users.email
    var passwordHash by Users.passwordHash
    var isActivated by Users.isActivated
    var avatarUrl by Users.avatarUrl
    var createdAt by Users.createdAt
    var updatedAt by Users.updatedAt

    fun toModel(): models.User {
        return models.User(
            lastName,
            firstName,
            email,
            avatarUrl,
            isActivated,
            createdAt.toIsoString(),
            updatedAt.toIsoString()
        )
    }
}