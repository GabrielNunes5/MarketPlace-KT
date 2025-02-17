package com.example.marketplace_api.repositories

import com.example.marketplace_api.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository: JpaRepository<Product, UUID> {
}