package com.dojinyou.numble.timedeal.domain.user.controller

import com.dojinyou.numble.timedeal.domain.user.dto.CreateUserDto
import com.dojinyou.numble.timedeal.domain.user.dto.UpdateUserDto
import com.dojinyou.numble.timedeal.domain.user.dto.UserDto
import com.dojinyou.numble.timedeal.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RequestMapping("/users")
@RestController
class UserController(
    private val userService: UserService,
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody createUserDto: CreateUserDto) {}

    //TODO: AUTH(사용자)
    @DeleteMapping("/my")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(userId: UUID) {}

    //TODO: AUTH(사용자)
    @PatchMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    fun updateUser(
        userId: UUID, // session에 저장된 userId 가져오기
        @RequestBody updateUserDto: UpdateUserDto,
    ) {}

    //TODO: AUTH(사용자/관리자)
    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    fun getMyUser(userId: UUID): UserDto {
        return UserDto()
    }
}
