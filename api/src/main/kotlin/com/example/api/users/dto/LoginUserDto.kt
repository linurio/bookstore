package com.example.api.users.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginUserDto(
    val email: String,
    val password: String
)
