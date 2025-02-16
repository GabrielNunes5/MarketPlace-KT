package com.example.marketplace_api.models
import jakarta.persistence.*

@Entity
@Table(name = "order_items")
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order,

    @ManyToMany
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product, // MutableList de produtos 

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val price: Double
)
