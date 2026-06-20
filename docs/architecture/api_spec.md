# API Spec

Base path: `/api/v1`

## Images

### POST /images/upload-url

Creates a signed upload URL.

Body:

```json
{
  "media_type": "image/jpeg",
  "purpose": "selfie"
}
```

## Face Analysis

### POST /face-analyses

Creates a face analysis job.

Body:

```json
{
  "image_id": "uuid"
}
```

Returns structured geometry when complete:

```json
{
  "id": "uuid",
  "status": "completed",
  "facial_regions": {},
  "landmarks": {},
  "geometry_measurements": {},
  "confidence_score": 0.92,
  "warnings": []
}
```

## Coaching

### POST /coaching-sessions

Creates a makeup coaching session.

Body:

```json
{
  "face_analysis_id": "uuid",
  "target_area": "lip_line",
  "goal": "natural"
}
```

### GET /coaching-sessions/{session_id}

Returns coaching instructions, overlay primitives, confidence, and warnings.

## Feedback

### POST /feedback-results

```json
{
  "before_image_id": "uuid",
  "after_image_id": "uuid",
  "target_area": "eyebrow",
  "user_notes": "optional"
}
```

Returns placement feedback, symmetry observations, confidence, and improvement suggestions.

## Recommendations

### POST /recommendations

```json
{
  "face_analysis_id": "uuid",
  "occasion": "daily",
  "style_goal": "soft"
}
```

Returns style strategy, occasion strategy, and product category suggestions.

## Reports

### GET /feedback-results/{id}

Returns feedback result detail.

## Deferred APIs

Color exploration, trace practice, friend review, and specific product catalog endpoints are deferred. Do not implement them in the MVP unless explicitly assigned.
