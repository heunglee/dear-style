# API Specification

## Base URL

/api/v1

## Authentication

Use bearer tokens or secure cookie sessions.

## Endpoints

### Auth

POST /auth/register

Request:

```json
{
  "email": "user@example.com",
  "password": "string",
  "display_name": "Jane"
}
```

POST /auth/login

GET /auth/me

POST /auth/logout

### Consent

GET /consents

POST /consents

```json
{
  "consent_type": "face_image_upload",
  "granted": true,
  "version": "2026-01"
}
```

### Images

POST /images/upload-url

```json
{
  "mime_type": "image/jpeg",
  "asset_type": "original_face"
}
```

Response:

```json
{
  "image_asset_id": "uuid",
  "upload_url": "signed-url",
  "storage_key": "string"
}
```

POST /images/{image_asset_id}/confirm

DELETE /images/{image_asset_id}

### Comparison Sessions

POST /comparison-sessions

```json
{
  "image_asset_id": "uuid",
  "session_type": "color_harmony_undertone",
  "environment_label": "natural_light"
}
```

GET /comparison-sessions/{session_id}

POST /comparison-sessions/{session_id}/complete

### Reviews

POST /comparison-sessions/{session_id}/self-review

```json
{
  "votes": [
    {
      "comparison_pair_id": "uuid",
      "selected_option": "A",
      "prompt_key": "harmonious",
      "confidence": 4
    }
  ]
}
```

### Friend Review Links

POST /comparison-sessions/{session_id}/friend-links

```json
{
  "expires_in_hours": 72,
  "max_reviews": 20
}
```

GET /friend-review/{token}

POST /friend-review/{token}/submit

```json
{
  "reviewer_alias": "Friend",
  "votes": [
    {
      "comparison_pair_id": "uuid",
      "selected_option": "B",
      "prompt_key": "brighter"
    }
  ]
}
```

### Reports

POST /comparison-sessions/{session_id}/report

GET /reports/{report_id}

GET /me/reports

### Products

GET /products

Query parameters:

- category
- undertone_tag
- brightness_tag
- saturation_tag

### Recommendations

GET /reports/{report_id}/recommendations

## Error Format

```json
{
  "error": {
    "code": "CONSENT_REQUIRED",
    "message": "Face image upload consent is required."
  }
}
```
