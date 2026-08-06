package net.joohnserde.forgex.model.auth

import jakarta.validation.constraints.NotBlank

class AuthRequest(

    val username: String? = null,

    val email: String? = null,

    @field:NotBlank
    val password: String
)
