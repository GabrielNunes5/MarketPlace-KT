package com.example.marketplace_api.models

import jakarta.persistence.*

@Entity
@Table(name = "sellers")
data class Seller(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val fullName: String,

    @Column(nullable = false)
    val storeName: String,

    @Column(nullable = false)
    val rating: Double
)

