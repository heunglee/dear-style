package com.deardaughterbeauty.dearstyle

import kotlinx.serialization.Serializable

class DearStyleApiClient(
    private val baseUrl: String = "http://10.0.2.2:8000/api/v1",
) {
    fun registerUrl() = "$baseUrl/auth/register"
    fun loginUrl() = "$baseUrl/auth/login"
    fun currentUserUrl() = "$baseUrl/auth/me"
    fun consentsUrl() = "$baseUrl/consents"
    fun imageUploadUrl() = "$baseUrl/images/upload-url"
    fun faceAnalysesUrl() = "$baseUrl/face-analyses"
    fun coachingSessionsUrl() = "$baseUrl/coaching-sessions"
    fun coachingSessionUrl(sessionId: String) = "$baseUrl/coaching-sessions/$sessionId"
    fun feedbackResultsUrl() = "$baseUrl/feedback-results"
    fun feedbackResultUrl(resultId: String) = "$baseUrl/feedback-results/$resultId"
    fun recommendationsUrl() = "$baseUrl/recommendations"
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
    val media_type: String,
    val purpose: String,
)

@Serializable
data class FaceAnalysisCreate(
    val image_id: String,
)

@Serializable
data class CoachingSessionCreate(
    val face_analysis_id: String,
    val target_area: String,
    val goal: String? = null,
)

@Serializable
data class FeedbackResultCreate(
    val before_image_id: String,
    val after_image_id: String,
    val target_area: String,
    val user_notes: String? = null,
)

@Serializable
data class RecommendationCreate(
    val face_analysis_id: String,
    val occasion: String? = null,
    val style_goal: String? = null,
)
