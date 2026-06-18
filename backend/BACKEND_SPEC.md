# Backend Specification

## Stack

- Python 3.14+
- FastAPI
- PostgreSQL
- SQLAlchemy 2.x
- Alembic
- Pydantic
- Redis
- Celery or Dramatiq
- pytest

## Modules

```text
app/
  main.py
  core/
    config.py
    security.py
    database.py
  auth/
  users/
  consents/
  images/
  comparisons/
  reviews/
  reports/
  products/
  recommendations/
  ai/
```

## Core Services

### AuthService

- register user
- authenticate user
- issue session/token
- get current user

### ConsentService

- record consent
- check required consent
- provide audit trail

### ImageService

- create upload URL
- confirm upload
- create signed read URL
- delete image
- enqueue optional image validation

### ComparisonService

- create comparison session
- generate comparison pairs
- retrieve session
- complete session

### ReviewService

- submit self review
- create friend link
- validate friend token
- submit friend review

### ReportService

- aggregate votes
- compute tendency scores
- generate explainable report JSON

### ProductService

- manage product catalog
- query products by tags

### RecommendationService

- recommend products based on report
- store recommendation events

## Background Jobs

- validate image quality
- generate thumbnails
- generate rendered comparison images if server-side rendering is enabled
- generate reports asynchronously for larger sessions
- clean expired friend-review links

## Testing Requirements

- unit tests for scoring functions
- API tests for all endpoints
- consent enforcement tests
- friend link expiry tests
- image deletion tests
- report generation tests

## Backend Acceptance Criteria

- All MVP APIs are implemented.
- All privacy-critical actions are tested.
- OpenAPI schema is generated.
- Local development works with Docker Compose.
