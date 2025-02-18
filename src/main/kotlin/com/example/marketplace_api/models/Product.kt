package com.example.marketplace_api.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    val seller: Seller,

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(columnDefinition = "TEXT")
    val description: String?,

    @Column(nullable = false, precision = 10, scale = 2)
    val price: BigDecimal,

    @Column(nullable = false)
    var stockQuantity: Int = 0,

    @CreationTimestamp
    val createdAt: Instant? = null
)