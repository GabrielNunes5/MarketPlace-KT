package com.example.marketplace_api.service

import com.example.marketplace_api.models.User
import com.example.marketplace_api.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository ) {

    fun findUserByEmail(email: String): Optional<User> {
        return userRepository.findByEmail(email)
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }
}