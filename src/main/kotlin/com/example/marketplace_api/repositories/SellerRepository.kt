package com.example.marketplace_api.repositories

import com.example.marketplace_api.models.Seller
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SellerRepository: JpaRepository<Seller, UUID> {
}