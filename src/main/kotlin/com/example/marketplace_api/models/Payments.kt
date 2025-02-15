package com.example.marketplace_api.models

import jakarta.persistence.*

@Entity
@Table(name = "payments")
data class Payments(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = true)
    val paymentMethod: String,

    @Column(nullable = true)
    val status: Boolean,

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order
)

