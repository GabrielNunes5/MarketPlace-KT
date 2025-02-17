package com.example.marketplace_api.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.UUID
import java.time.Instant

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, length = 100, unique = true)
    val username: String,

    @Column(nullable = false, unique = true, length = 100)
    val email: String,

    @Column(nullable = false, length = 100)
    val fullname: String,

    @Column(nullable = false)
    val password: String,

    @CreationTimestamp
    val createdAt: Instant? = null,

    @UpdateTimestamp
    val updatedAt: Instant? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orders: MutableList<Order> = mutableListOf()
)

