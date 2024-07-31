package models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatarUrl: String?,
    @Transient val passwordHash: String = "",
    val isActivated: Boolean,
    val createdAt: String,
    val updatedAt: String,
)
