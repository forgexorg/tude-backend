package net.joohnserde.forgex.service.auth

import net.joohnserde.forgex.model.auth.AuthRequest
import net.joohnserde.forgex.model.auth.AuthResponse
import net.joohnserde.forgex.model.auth.RegisterRequest

interface AuthService {

    fun login(authRequest: AuthRequest): AuthResponse

    fun register(registerRequest: RegisterRequest): AuthResponse
}
