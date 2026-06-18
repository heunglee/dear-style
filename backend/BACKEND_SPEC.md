# Backend Spec

## Stack

- Python 3.12+
- FastAPI
- PostgreSQL
- SQLAlchemy 2.x
- Alembic
- Pydantic
- pytest

## Modules

```text
app/
  main.py
  api/
    lessons.py
    practice.py
    media.py
    reviews.py
    reports.py
  core/
    config.py
    security.py
  db/
    session.py
    models.py
    migrations/
  services/
    trace_scoring.py
    review_summary.py
    media_storage.py
  schemas/
    lessons.py
    practice.py
    reviews.py
```

## Required Services

### TraceScoringService

Input:

- target path
- user path

Output:

- angle_score
- length_score
- smoothness_score
- endpoint_score
- total_score
- feedback

### LessonService

Manages content-backed style lessons and drawing templates.

### ReviewService

Creates review sessions and aggregates votes.

### MediaService

Creates upload URLs and tracks media metadata.

## Seed Data

Initial lessons:

- Natural Tightline
- Soft Outer Third Line
- Soft Cat Eye
- Classic Cat Eye
- Puppy Eye
- Horizontal Extension

## Testing

Unit tests required for:

- trace scoring
- lesson filtering
- review token expiration
- review aggregation
- media soft delete
