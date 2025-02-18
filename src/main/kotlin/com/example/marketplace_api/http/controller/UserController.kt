package com.example.marketplace_api.http.controller

import com.example.marketplace_api.models.User
import com.example.marketplace_api.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import java.net.URI
import java.util.UUID

@Component
class UserController(private val userService: UserService) {

    fun createUser(request: ServerRequest): ServerResponse {
        val user = request.body(User::class.java)
        val savedUser = userService.saveUser(user)
        return ServerResponse.created(URI.create("/user/${savedUser.id}")).build()
    }

    fun getUsers(request: ServerRequest): ServerResponse {
        val users = userService.findAll()
        return ServerResponse.ok().body(users)
    }

    fun getUserByEmail(request: ServerRequest): ServerResponse {
        val email = request.pathVariable("email")
        val user = userService.findUserByEmail(email)
            ?: return ServerResponse.notFound().build()
        return ServerResponse.ok().body(user)
    }

    fun getUserById(request: ServerRequest): ServerResponse {
        val id = UUID.fromString(request.pathVariable("id"))
        val user = userService.findUserById(id)
            ?: return ServerResponse.notFound().build()
        return ServerResponse.ok().body(user)
    }

    fun updateUserById(request: ServerRequest): ServerResponse {
        val id = UUID.fromString(request.pathVariable("id"))
        val updatedData = request.body(User::class.java)
        val updatedUser = userService.updateUserById(id, updatedData)
            ?: return ServerResponse.notFound().build()
        return ServerResponse.ok().body(updatedUser)
    }

    fun deleteUserById(request: ServerRequest): ServerResponse {
        val id = UUID.fromString(request.pathVariable("id"))
            ?: return ServerResponse.notFound().build()
        userService.deleteUser(id)
        return ServerResponse.noContent().build()
    }
}