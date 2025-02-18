package com.example.marketplace_api.service

import com.example.marketplace_api.exception.UserNotFoundException
import com.example.marketplace_api.models.User
import com.example.marketplace_api.repositories.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository ) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findUserByEmail(email: String): User =
        userRepository.findByEmail(email)
            ?: throw UserNotFoundException("User with email $email not found")

    fun findUserById(id: UUID): User = userRepository.findByIdOrNull(id)
        ?: throw UserNotFoundException("User with id $id not found")

    fun updateUser(id: UUID, updatedData: User): User? {
        val existingUser = userRepository.findByIdOrNull(id) ?: return null
        val updatedUser = existingUser.copy(
            username = updatedData.username,
            email = updatedData.email,
            fullName = updatedData.fullName,
            password = updatedData.password
        )
        return userRepository.save(updatedUser)
    }

    fun deleteUser(userId: UUID) {
        userRepository.deleteById(userId)
    }
}