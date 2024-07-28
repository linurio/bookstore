package com.example.api.users.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatarUrl: String?,
    val isActivated: Boolean,
    val createdAt: String,
    val updatedAt: String,
)
