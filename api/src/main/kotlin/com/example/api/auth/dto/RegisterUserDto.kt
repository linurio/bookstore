package com.example.api.auth.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val avatarUrl: String? = ""
)
