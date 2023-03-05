package com.dojinyou.numble.timedeal.global.exception


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.tinylog.Level
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
    fun handleException(exception: Exception) = logAndReturnMessage(exception, Level.ERROR)

    private fun logAndReturnMessage(exception: Exception, level:Level = Level.WARN): String {
        val message = exception.message.toString()
        val loggingMessage = "$exception: $message"
        loggingByLevel(level, loggingMessage)
        return message
    }

    private fun loggingByLevel(level: Level, loggingMessage: String) {
        when (level) {
            Level.INFO -> logger.info { loggingMessage }
            Level.TRACE -> logger.trace { loggingMessage }
            Level.DEBUG -> logger.debug { loggingMessage }
            Level.WARN -> logger.warn { loggingMessage }
            Level.ERROR -> logger.error { loggingMessage }
            Level.OFF -> {}
        }
    }
}
