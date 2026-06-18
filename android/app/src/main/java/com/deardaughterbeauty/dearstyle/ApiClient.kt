package com.deardaughterbeauty.dearstyle

import kotlinx.serialization.Serializable

class DearStyleApiClient(
    private val baseUrl: String = "http://10.0.2.2:8000/api/v1",
) {
    fun registerUrl() = "$baseUrl/auth/register"
    fun loginUrl() = "$baseUrl/auth/login"
    fun consentsUrl() = "$baseUrl/consents"
}

@Serializable
data class RegisterRequest(
    val email: String,
    val password: String,
    val display_name: String? = null,
)

@Serializable
data class LoginRequest(
    val email: String,
    val password: String,
)

@Serializable
data class ConsentCreate(
    val consent_type: String,
    val granted: Boolean,
    val version: String,
)
