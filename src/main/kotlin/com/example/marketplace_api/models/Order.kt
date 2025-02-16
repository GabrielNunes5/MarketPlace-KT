package com.example.marketplace_api.models
import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @OneToOne
    val orderItems: OrderItem,

    @Column(nullable = false)
    val totalPrice: Double,

    @Column(nullable = false)
    val status: String
)
