package com.example.marketplace_api.exception

data class ErrorResponse(
    val status: Int,
    val message: String
)