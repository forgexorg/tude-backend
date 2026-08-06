package net.joohnserde.forgex.exception

import jakarta.validation.ConstraintViolationException
import net.joohnserde.forgex.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = notFoundException.message!!
        )
    }

    @ExceptionHandler(value = [UnauthenticatedException::class])
    fun unauthenticated(unauthenticatedException: UnauthenticatedException): WebResponse<String> {
        return WebResponse(
            code = 401,
            status = "UNAUTHENTICATED",
            data = unauthenticatedException.message!!
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            code = 403,
            status = "UNAUTHORIZED",
            data = unauthorizedException.message!!
        )
    }
}
