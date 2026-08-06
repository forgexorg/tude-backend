package net.joohnserde.forgex.model.auth

import java.util.Date

class AuthResponse(

    val name: String,

    val username: String,

    val email: String,

    val registered_at: Date
)
