package com.example.api.users.entities

import com.example.api.users.Users
import com.example.api.utils.toIsoString
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

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
            id.value,
            lastName,
            firstName,
            email,
            avatarUrl,
            passwordHash,
            isActivated,
            createdAt.toIsoString(),
            updatedAt.toIsoString()
        )
    }
}