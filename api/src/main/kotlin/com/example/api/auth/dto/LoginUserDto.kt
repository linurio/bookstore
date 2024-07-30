package com.example.api.auth.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginUserDto(
    val email: String,
    val password: String
)
