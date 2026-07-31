package net.joohnserde.forgex.service.auth

import jakarta.validation.ConstraintViolationException
import net.joohnserde.forgex.entity.user.User
import net.joohnserde.forgex.exception.UnauthenticatedException
import net.joohnserde.forgex.model.auth.AuthRequest
import net.joohnserde.forgex.model.auth.AuthResponse
import net.joohnserde.forgex.model.auth.RegisterRequest
import net.joohnserde.forgex.service.auth.AuthService
import net.joohnserde.forgex.repository.user.UserRepository
import net.joohnserde.forgex.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.Date

@Service
class AuthServiceImpl(

    private val userRepository: UserRepository,

    private val validationUtil: ValidationUtil,

    private val passwordEncoder: PasswordEncoder

) : AuthService {

    override fun login(authRequest: AuthRequest): AuthResponse {

        validationUtil.validate(authRequest)

        val user: User? = when {

            authRequest.username != null -> {
                userRepository.findByUsername(authRequest.username)
            }

            authRequest.email != null -> {
                userRepository.findByEmail(authRequest.email)
            }

            else -> throw UnauthenticatedException("username or email is empty")

        } ?: throw UnauthenticatedException("email or password is incorrect")

        if (!passwordEncoder.matches(authRequest.password, user?.password))
            throw UnauthenticatedException("email or password is incorrect")

        return toAuthResponse(user!!)
    }

    override fun register(registerRequest: RegisterRequest): AuthResponse {

        validationUtil.validate(registerRequest)

        val checkEmail = userRepository.findByEmail(registerRequest.email)

        if (checkEmail != null) throw UnauthenticatedException("the email is already registered")

        val newUser = User(
            name = registerRequest.name,
            username = registerRequest.username,
            email = registerRequest.email,
            password = registerRequest.newPassword,
            role = "USER",
            registered_at = Date()
        )

        userRepository.save(newUser)

        return toAuthResponse(newUser)
    }


    // Util

    private fun toAuthResponse(user: User): AuthResponse {
        return AuthResponse(
            name = user.name,
            username = user.username,
            email = user.email,
            registered_at = user.registered_at
        )
    }
}
