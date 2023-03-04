package com.dojinyou.numble.timedeal.global.auth

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/auth")
@RestController
class AuthController(
    private val authService: AuthService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun signIn(@RequestBody signInDto: SignInDto): String {
        return "newSessionId"
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun signOut(sessionId:String) {}

}
