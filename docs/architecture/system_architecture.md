# System Architecture

## Overview

Dear Style v2 is a cross-platform AI makeup coaching application with a shared backend, responsive web app, Android app, and iOS app.

The MVP should isolate face analysis, makeup coaching, recommendation, and QA as clear service boundaries. The product may begin with simple rules and local models, but the architecture should allow the vision and coaching layers to improve independently.

## Components

```text
Web App
Android App
iOS App
    |
FastAPI Backend
    |
PostgreSQL
Object Storage
    |
Optional Job Queue
Optional Vision Service
Optional LLM/Coaching Service
```

## Agent Boundaries

### Face Analysis Agent

- Accepts validated face images.
- Extracts landmarks and feature regions.
- Produces structured facial geometry.

### Makeup Coach Agent

- Reads facial geometry and user goals.
- Generates lip, eyebrow, blush, and correction guides.
- Produces overlay instructions and step-by-step text.

### Recommendation Agent

- Reads goals, profile, context, and coaching history.
- Suggests style strategy, occasion strategy, and product categories.

### QA Agent

- Validates image quality, geometry confidence, and output safety.
- Flags poor image quality and low-confidence coaching.

## Backend Responsibilities

- authentication
- user profile management
- consent and privacy controls
- image upload metadata
- face analysis job orchestration
- coaching session APIs
- feedback result APIs
- recommendation APIs
- report generation

## Client Responsibilities

- account and consent flow
- selfie capture and upload
- coaching result display
- overlay rendering
- before/after capture
- feedback review
- local privacy affordances for camera/photo access

## Storage

Image files should be stored outside the relational database. Store only metadata and references in PostgreSQL.

## Privacy

Face images are sensitive. Default retention should be minimal. Users must be able to delete uploaded images.
