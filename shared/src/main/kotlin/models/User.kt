package models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatarUrl: String?,
    val passwordHash: String,
    val isActivated: Boolean,
    val createdAt: String,
    val updatedAt: String,
)
