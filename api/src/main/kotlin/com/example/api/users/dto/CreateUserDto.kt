package com.example.api.users.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val passwordHash: String,
    val avatarUrl: String?,
)
