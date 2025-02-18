package com.example.marketplace_api.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.*

@Entity
@Table(name = "sellers")
data class Seller(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, length = 20, unique = true)
    val taxId: String,

    @Column(length = 100)
    val companyName: String?,

    @CreationTimestamp
    val createdAt: Instant? = null,

    @OneToMany(mappedBy = "seller", cascade = [CascadeType.ALL], orphanRemoval = true)
    val products: MutableList<Product> = mutableListOf()
)

