package com.example.marketplace_api.repository

import com.example.marketplace_api.models.Payments
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentsRepository: JpaRepository<Payments, Long> {
}