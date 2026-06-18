package com.deardaughterbeauty.dearstyle

import kotlinx.serialization.Serializable

class DearStyleApiClient(
    private val baseUrl: String = "http://10.0.2.2:8000/api/v1",
) {
    fun registerUrl() = "$baseUrl/auth/register"
    fun loginUrl() = "$baseUrl/auth/login"
    fun consentsUrl() = "$baseUrl/consents"
    fun imageUploadUrl() = "$baseUrl/images/upload-url"
    fun imageConfirmUrl(imageAssetId: String) = "$baseUrl/images/$imageAssetId/confirm"
    fun comparisonSessionsUrl() = "$baseUrl/comparison-sessions"
    fun selfReviewUrl(sessionId: String) = "$baseUrl/comparison-sessions/$sessionId/self-review"
    fun reportUrl(sessionId: String) = "$baseUrl/comparison-sessions/$sessionId/report"
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

@Serializable
data class UploadUrlRequest(
    val mime_type: String,
    val asset_type: String,
)

@Serializable
data class UploadUrlResponse(
    val image_asset_id: String,
    val upload_url: String,
    val storage_key: String,
)

@Serializable
data class ImageConfirmRequest(
    val width: Int? = null,
    val height: Int? = null,
)

@Serializable
data class ComparisonSessionCreate(
    val image_asset_id: String,
    val session_type: String,
    val environment_label: String? = null,
)

@Serializable
data class SelfReviewCreate(
    val votes: List<ReviewVoteCreate>,
)

@Serializable
data class ReviewVoteCreate(
    val comparison_pair_id: String,
    val selected_option: String,
    val prompt_key: String,
    val confidence: Int,
)
