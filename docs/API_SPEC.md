# API Spec

Base path: `/api/v1`

## Lessons

### GET /lessons

Query:

- category
- impression
- difficulty

Returns active style lessons.

### GET /lessons/{lesson_id}

Returns lesson detail, instructions, templates, and common mistakes.

## Practice

### POST /practice-sessions

Body:

```json
{
  "lesson_id": "uuid"
}
```

Creates a session.

### POST /practice-sessions/{session_id}/trace-attempts

Body:

```json
{
  "template_id": "uuid",
  "input_path": [{"x": 0.1, "y": 0.2, "t": 1000}]
}
```

Returns trace scoring.

### GET /practice-sessions/{session_id}

Returns session and attempts.

## Media

### POST /media/upload-url

Creates signed upload URL.

Body:

```json
{
  "media_type": "image/jpeg",
  "purpose": "before_photo"
}
```

## Application Results

### POST /application-results

Body:

```json
{
  "lesson_id": "uuid",
  "before_image_id": "uuid",
  "after_image_id": "uuid",
  "user_notes": "optional"
}
```

### GET /application-results/{id}

Returns result detail.

## Reviews

### POST /review-sessions

Body:

```json
{
  "application_result_id": "uuid",
  "prompt": "Which look feels more professional?"
}
```

Returns share URL.

### GET /review-sessions/{share_token}

Public endpoint for invited reviewers.

### POST /review-sessions/{share_token}/votes

Body:

```json
{
  "selected_option": "after",
  "impression_ratings": {
    "professional": 4,
    "natural": 3
  },
  "comment": "Looks cleaner"
}
```

## Reports

### GET /application-results/{id}/report

Returns self/friend/AI summary.

## Color Exploration

All endpoints are deferred. Do not implement in MVP unless explicitly assigned.
