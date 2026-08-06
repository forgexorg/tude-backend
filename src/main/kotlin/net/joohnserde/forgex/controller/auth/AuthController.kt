package net.joohnserde.forgex.controller.auth

import net.joohnserde.forgex.model.WebResponse
import net.joohnserde.forgex.model.auth.AuthRequest
import net.joohnserde.forgex.model.auth.AuthResponse
import net.joohnserde.forgex.model.auth.RegisterRequest
import net.joohnserde.forgex.service.auth.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService) {

    @PostMapping(
        value = ["/api/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(
        @RequestBody authRequest: AuthRequest
    ): WebResponse<AuthResponse> {

        val response = authService.login(authRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PostMapping(
        value = ["/api/register"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun register(
        @RequestBody registerRequest: RegisterRequest
    ): WebResponse<AuthResponse> {

        val response = authService.register(registerRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}
