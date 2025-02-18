package com.example.marketplace_api.repositories

import com.example.marketplace_api.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?

}