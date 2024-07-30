package com.example.api.users.dto

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserDto(
    val firstName: String? = null,
    val lastName: String? = null,
    val passwordHash: String? = null,
    val isActivated: Boolean? = null,
    val avatarUrl: String? = null,
    val updatedAt: String? = null,
    val refreshToken: String? = null
)
