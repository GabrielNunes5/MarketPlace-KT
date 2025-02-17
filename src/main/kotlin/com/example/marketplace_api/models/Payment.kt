package com.example.marketplace_api.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "payments")
data class Payment(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    val order: Order,

    @Column
    val amount: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    val method: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    var status: String,

    @Column(unique = true)
    val transactionId: String?,

    @CreationTimestamp
    val createdAt: Instant? = null,
)
