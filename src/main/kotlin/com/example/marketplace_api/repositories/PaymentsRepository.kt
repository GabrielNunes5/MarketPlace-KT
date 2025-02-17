package com.example.marketplace_api.repositories

import com.example.marketplace_api.models.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PaymentsRepository: JpaRepository<Payment, UUID> {
}