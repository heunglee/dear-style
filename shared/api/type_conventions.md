# Shared API Type Conventions

This directory defines the cross-platform API type conventions for Dear Style.

The backend owns runtime validation. Web, Android, and iOS should mirror these names and values in
their local DTOs until generated clients are introduced.

## Naming

- JSON fields use `snake_case`.
- Type names use each platform's normal casing:
  - Python/Pydantic: `PascalCase` models with snake_case fields
  - TypeScript/Zod: `camelCase` type aliases are allowed, but parsed JSON fields stay `snake_case`
  - Kotlin serialization: `PascalCase` data classes with snake_case serial names or properties
  - Swift Codable: `PascalCase` structs with `CodingKeys` mapping to snake_case
- IDs are UUID strings over the wire.
- Dates and datetimes are ISO 8601 strings.
- Confidence values are numbers from `0.0` to `1.0`.
- Warnings are arrays of short machine-readable strings unless a richer warning object is specified.

## Canonical Enums

### ConsentType

```text
face_image_upload
raw_image_storage
friend_review_sharing
anonymized_analytics
```

### ImagePurpose

```text
selfie
before
after
```

### CoachingTargetArea

```text
lip_line
eyebrow
blush
full_feedback
```

### JobStatus

```text
pending
processing
completed
failed
```

### CoachingSessionStatus

```text
started
completed
failed
```

## Core DTO Names

### Auth

- `RegisterRequest`
- `LoginRequest`
- `AuthResponse`
- `UserRead`

### Consent

- `ConsentCreate`
- `ConsentRead`

### Images

- `UploadUrlRequest`
- `UploadUrlResponse`

### Face Analysis

- `FaceAnalysisCreate`
- `FaceAnalysisRead`

### Coaching

- `CoachingSessionCreate`
- `CoachingSessionRead`
- `CoachingGuideRead`

### Feedback

- `FeedbackResultCreate`
- `FeedbackResultRead`

### Recommendations

- `RecommendationCreate`
- `RecommendationRead`

## Deferred Types

Color exploration, trace practice, friend review, and specific product catalog types are deferred.
Do not introduce runtime API DTOs for them until the corresponding later phase reopens that scope.
