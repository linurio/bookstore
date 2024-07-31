package com.example.api.users.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserDto(
    val name: String,
    val email: String,
    val password: String,
    val avatarUrl: String?,
)
