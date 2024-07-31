package com.example.api.auth

import com.example.api.users.UserService
import com.example.api.users.dto.CreateUserDto
import com.example.api.users.dto.LoginUserDto
import com.example.api.users.dto.UpdateUserDto
import kotlinx.serialization.Serializable
import models.User
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class AuthResult(
    val success: AuthSuccess? = null,
    val error: AuthError? = null
)

@Serializable
sealed class AuthError(val message: String) {
    @Serializable
    data object PasswordTooShort : AuthError("Password must be at least 8 characters long.")

    @Serializable
    data object UserNotFound : AuthError("User not found.")

    @Serializable
    data object IncorrectPassword : AuthError("Incorrect password.")

    @Serializable
    data class Unknown(val msg: String) : AuthError(msg)
}

@Serializable
data class AuthSuccess(
    val user: User,
    val tokenPair: TokenPair,
)

@Serializable
data class TokenPair(
    val accessToken: String,
    val refreshToken: String
)

class AuthService(private val userService: UserService) {
    suspend fun register(data: CreateUserDto): AuthResult {
        if (data.password.length < 8) {
            return AuthResult(error = AuthError.PasswordTooShort)
        }

        val passwordHash = this.hashPassword(data.password)

        val user = this.userService.create(
            CreateUserDto(
                firstName = data.firstName,
                lastName = data.lastName,
                avatarUrl = data.avatarUrl,
                email = data.email,
                password = passwordHash,
            )
        )

        if (user != null) {
            val tokenPair = this.generateTokenPair(user.id)
            return AuthResult(AuthSuccess(user, tokenPair))
        }


        return AuthResult(error = AuthError.Unknown("Registration failed. Please try again"))
    }

    suspend fun login(data: LoginUserDto): AuthResult {
        val user = this.userService.findByEmail(data.email) ?: return AuthResult(
            error = AuthError.UserNotFound
        )

        val isPasswordCorrect = this.checkPassword(data.password, user.passwordHash)
        if (!isPasswordCorrect) return AuthResult(error = AuthError.IncorrectPassword)

        val tokenPair = this.generateTokenPair(user.id)

        this.userService.update(user.id, UpdateUserDto(refreshToken = tokenPair.refreshToken))

        return AuthResult(AuthSuccess(user, tokenPair))
    }

    private fun generateTokenPair(userId: Int): TokenPair {

        // TODO: generate actual tokens
        return TokenPair(
            accessToken = "Bearer access $userId",
            refreshToken = "Bearer refresh $userId"
        )
    }

    private fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    private fun checkPassword(password: String, hashed: String): Boolean {
        return BCrypt.checkpw(password, hashed)
    }
}