# Backend Spec

## Stack

- Python 3.14.6
- FastAPI 0.138.x
- PostgreSQL 18.4
- SQLAlchemy 2.0.x
- Alembic 1.18.x
- Psycopg 3.3.x
- Pydantic v2 / pydantic-settings 2.14.x
- Uvicorn 0.49.x
- pytest 9.x
- Ruff 0.15.x

## Modules

```text
app/
  main.py
  api/
    face_analyses.py
    coaching_sessions.py
    media.py
    feedback_results.py
    recommendations.py
  core/
    config.py
    security.py
  db/
    session.py
    models.py
    migrations/
  services/
    face_analysis.py
    makeup_coaching.py
    feedback_summary.py
    media_storage.py
  schemas/
    face_analyses.py
    coaching.py
    feedback.py
```

## Required Services

### FaceAnalysisService

Input:

- source image metadata
- validated image reference

Output:

- facial regions
- landmarks
- geometry measurements
- confidence score
- warnings

### MakeupCoachingService

Generates lip line, eyebrow, blush, and before/after feedback guidance.

### RecommendationService

Generates style, occasion, and product category strategy.

### MediaService

Creates upload URLs and tracks media metadata.

## Testing

Unit tests required for:

- image quality validation
- face analysis confidence handling
- coaching output schemas
- feedback result generation
- recommendation safety rules
- media soft delete
