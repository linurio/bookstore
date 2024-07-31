package com.example.api.users

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object Users : IntIdTable() {
    val name = varchar("name", 255)
    val email = varchar("email", 255).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val isActivated = bool("is_activated")
    val avatarUrl = varchar("avatar_url", 255).nullable()
    val refreshToken = varchar("refresh_token", 255).nullable()
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}
