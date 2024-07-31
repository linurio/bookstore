package models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val avatarUrl: String?,
    @Transient val passwordHash: String = "",
    val isActivated: Boolean,
    val createdAt: String,
    val updatedAt: String,
)
