package com.example.marketplace_api.controller

import com.example.marketplace_api.models.User
import com.example.marketplace_api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping
    fun createUser(@RequestBody user: User) : User {
        val createdUser = userService.saveUser(user)
        return createdUser
    }

    @GetMapping("{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<Optional<User>> {
        val user = userService.findUserByEmail(email)
        return ResponseEntity.ok(user)
    }

}