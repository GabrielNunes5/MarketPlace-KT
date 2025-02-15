package com.example.marketplace_api.models

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val price: Double,

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    val seller: Seller
)