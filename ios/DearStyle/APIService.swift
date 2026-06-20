import Foundation

struct RegisterRequest: Encodable {
    let email: String
    let password: String
    let displayName: String?

    enum CodingKeys: String, CodingKey {
        case email
        case password
        case displayName = "display_name"
    }
}

struct LoginRequest: Encodable {
    let email: String
    let password: String
}

struct AuthResponse: Decodable {
    let accessToken: String
    let tokenType: String
    let user: User

    enum CodingKeys: String, CodingKey {
        case accessToken = "access_token"
        case tokenType = "token_type"
        case user
    }
}

struct User: Decodable {
    let id: UUID
    let email: String
    let displayName: String?
    let createdAt: Date

    enum CodingKeys: String, CodingKey {
        case id
        case email
        case displayName = "display_name"
        case createdAt = "created_at"
    }
}

struct ConsentCreate: Encodable {
    let consentType: String
    let granted: Bool
    let version: String

    enum CodingKeys: String, CodingKey {
        case consentType = "consent_type"
        case granted
        case version
    }
}

struct UploadURLRequest: Encodable {
    let mediaType: String
    let purpose: String

    enum CodingKeys: String, CodingKey {
        case mediaType = "media_type"
        case purpose
    }
}

struct FaceAnalysisCreate: Encodable {
    let imageID: UUID

    enum CodingKeys: String, CodingKey {
        case imageID = "image_id"
    }
}

struct CoachingSessionCreate: Encodable {
    let faceAnalysisID: UUID
    let targetArea: String
    let goal: String?

    enum CodingKeys: String, CodingKey {
        case faceAnalysisID = "face_analysis_id"
        case targetArea = "target_area"
        case goal
    }
}

struct FeedbackResultCreate: Encodable {
    let beforeImageID: UUID
    let afterImageID: UUID
    let targetArea: String
    let userNotes: String?

    enum CodingKeys: String, CodingKey {
        case beforeImageID = "before_image_id"
        case afterImageID = "after_image_id"
        case targetArea = "target_area"
        case userNotes = "user_notes"
    }
}

struct RecommendationCreate: Encodable {
    let faceAnalysisID: UUID
    let occasion: String?
    let styleGoal: String?

    enum CodingKeys: String, CodingKey {
        case faceAnalysisID = "face_analysis_id"
        case occasion
        case styleGoal = "style_goal"
    }
}

final class APIService {
    private let baseURL: URL
    private let session: URLSession
    private let decoder: JSONDecoder
    private let encoder: JSONEncoder

    init(
        baseURL: URL = URL(string: "http://localhost:8000/api/v1")!,
        session: URLSession = .shared
    ) {
        self.baseURL = baseURL
        self.session = session
        self.decoder = JSONDecoder()
        self.encoder = JSONEncoder()
        self.decoder.dateDecodingStrategy = .iso8601
        self.encoder.keyEncodingStrategy = .useDefaultKeys
    }

    func register(_ payload: RegisterRequest) async throws -> AuthResponse {
        try await send("/auth/register", method: "POST", body: payload)
    }

    func login(_ payload: LoginRequest) async throws -> AuthResponse {
        try await send("/auth/login", method: "POST", body: payload)
    }

    func recordConsent(_ payload: ConsentCreate, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/consents",
            method: "POST",
            body: payload,
            token: token
        )
    }

    func createUploadURL(_ payload: UploadURLRequest, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/images/upload-url",
            method: "POST",
            body: payload,
            token: token
        )
    }

    func createFaceAnalysis(_ payload: FaceAnalysisCreate, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/face-analyses",
            method: "POST",
            body: payload,
            token: token
        )
    }

    func createCoachingSession(_ payload: CoachingSessionCreate, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/coaching-sessions",
            method: "POST",
            body: payload,
            token: token
        )
    }

    func createFeedbackResult(_ payload: FeedbackResultCreate, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/feedback-results",
            method: "POST",
            body: payload,
            token: token
        )
    }

    func createRecommendation(_ payload: RecommendationCreate, token: String) async throws {
        let _: EmptyResponse = try await send(
            "/recommendations",
            method: "POST",
            body: payload,
            token: token
        )
    }

    private func send<RequestBody: Encodable, ResponseBody: Decodable>(
        _ path: String,
        method: String,
        body: RequestBody,
        token: String? = nil
    ) async throws -> ResponseBody {
        var request = URLRequest(url: baseURL.appendingPathComponent(path.trimmingCharacters(in: CharacterSet(charactersIn: "/"))))
        request.httpMethod = method
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")

        if let token {
            request.setValue("Bearer \(token)", forHTTPHeaderField: "Authorization")
        }

        request.httpBody = try encoder.encode(body)

        let (data, response) = try await session.data(for: request)
        guard let httpResponse = response as? HTTPURLResponse,
              (200..<300).contains(httpResponse.statusCode) else {
            throw URLError(.badServerResponse)
        }

        if ResponseBody.self == EmptyResponse.self {
            return EmptyResponse() as! ResponseBody
        }

        return try decoder.decode(ResponseBody.self, from: data)
    }
}

private struct EmptyResponse: Decodable {}
