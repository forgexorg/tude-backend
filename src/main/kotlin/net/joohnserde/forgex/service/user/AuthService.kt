package net.joohnserde.forgex.repository.user

import net.joohnserde.forgex.model.auth

interface AuthService {

    fun login(authRequest: AuthService)

    fun register(authRequest: AuthService)
}
