package org.com.myrealtripassignment.presentation.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    class ErrorMessage(val message: String)

    @ExceptionHandler(
        value = [
            IllegalArgumentException::class,
            IllegalStateException::class
        ]
    )
    fun handleIllegalArgument(e: RuntimeException): ResponseEntity<ErrorMessage> {
        val status = when (e) {
            is IllegalArgumentException -> HttpStatus.BAD_REQUEST
            is IllegalStateException -> HttpStatus.CONFLICT
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }
        return ResponseEntity.status(status).body(e.message?.let { ErrorMessage(message = it) })
    }


}
