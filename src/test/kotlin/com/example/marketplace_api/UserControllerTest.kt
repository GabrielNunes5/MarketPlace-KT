package com.example.marketplace_api

import com.example.marketplace_api.models.User
import com.example.marketplace_api.repositories.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.transaction.Transactional
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class UserControllerTest {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var userRepository: UserRepository
    @Autowired private lateinit var objectMapper: ObjectMapper
    private lateinit var savedUser: User

    @BeforeEach
    fun setup() {
        userRepository.deleteAll()
        savedUser = userRepository.save(
            User(
                username = "testuser",
                email = "test@example.com",
                fullName = "Test User",
                password = "password"
            )
        )
    }

    @Test
    fun `should create new user`() {
        val newUser = User(
            username = "testuser2",
            email = "test2@example.com",
            fullName = "Test User2",
            password = "password2"
        )
        val newUserJson = objectMapper.writeValueAsString(newUser)
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(newUserJson))
            .andExpect(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    fun `should test find all users`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray)
    }

    @Test
    fun `should test find one user with email`() {
        val userEmail = savedUser.email
        mockMvc.perform(MockMvcRequestBuilders.get("/users/email/$userEmail"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(userEmail))
    }

    @Test
    fun `should test find one user with id`() {
        val userId = savedUser.id.toString()
        mockMvc.perform(MockMvcRequestBuilders.get("/users/$userId"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
    }

    @Test
    fun `should test delete user`() {
        val userId = savedUser.id.toString()
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/$userId"))
            .andExpect(MockMvcResultMatchers.status().isNoContent)
    }

}
