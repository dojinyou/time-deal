package com.dojinyou.numble.timedeal.global.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.tinylog.Logger

@RestControllerAdvice
class GlobalExceptionController {

    private val logger = Logger.tag("EXCEPTION")

    @ExceptionHandler(AuthenticationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthenticationException(exception: AuthenticationException) = logAndReturnMessage(exception)

    @ExceptionHandler(AuthorizationException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleAuthorizationException(exception: AuthorizationException) = logAndReturnMessage(exception)

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: NotFoundException) = logAndReturnMessage(exception)

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception) = logAndReturnMessage(exception)

    private fun logAndReturnMessage(exception: Exception): String {
        val message = exception.message.toString()
        logger.warn { "$exception: $message" }
        return message
    }
}
