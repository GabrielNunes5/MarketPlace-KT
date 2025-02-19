package com.example.marketplace_api.service

import com.example.marketplace_api.exception.UserNotFoundException
import com.example.marketplace_api.models.User
import com.example.marketplace_api.repositories.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun saveUser(user: User): User {
        val userToSave = user.copy(password = passwordEncoder.encode(user.password))
        return userRepository.save(userToSave)
    }

    fun findAll(): List<User> {
        return userRepository.findAll().ifEmpty {
            throw UserNotFoundException("No users found in the database")
        }
    }

    fun findUserByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException("User with email $email not found")
    }

    fun findUserById(id: UUID): User {
        return userRepository.findByIdOrNull(id)
            ?: throw UserNotFoundException("User with id $id not found")
    }

    fun updateUser(id: UUID, updatedData: User): User {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw UserNotFoundException("User with id $id not found")

        val updatedUser = existingUser.copy(
            username = updatedData.username,
            email = updatedData.email,
            fullName = updatedData.fullName,
            password = passwordEncoder.encode(updatedData.password)
        )

        return userRepository.save(updatedUser)
    }

    fun deleteUser(userId: UUID) {
        val user = userRepository.findByIdOrNull(userId)
            ?: throw UserNotFoundException("User with id $userId not found")
        userRepository.delete(user)
    }
}