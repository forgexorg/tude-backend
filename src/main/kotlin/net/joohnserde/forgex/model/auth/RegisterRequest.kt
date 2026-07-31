package net.joohnserde.forgex.model.auth

import jakarta.validation.constraints.NotBlank

class RegisterRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val username: String,

    @field:NotBlank
    val email: String,

    @field:NotBlank
    val newPassword: String
)
