# System Architecture

## Overview

Dear Style is a multi-platform application with a shared backend API and native/web clients.

## Components

- Backend API: FastAPI
- Database: PostgreSQL
- Object Storage: S3-compatible storage
- Async Processing: Redis + Celery or Dramatiq
- Web Client: Next.js + TypeScript
- Android Client: Kotlin or Java
- iOS Client: Swift + SwiftUI
- AI Services: modular internal services

## High-Level Flow

1. User signs in.
2. User accepts face image consent.
3. User uploads or captures face image.
4. Backend stores image asset and derived metadata.
5. User starts comparison session.
6. Backend returns test pairs and overlay parameters.
7. Client renders A/B options.
8. User votes.
9. Optional friend-review link is generated.
10. Friend votes are collected.
11. Report is generated from self and friend choices.
12. Future AI agents enrich the report.

## Service Boundaries

### Auth Service

- user registration
- login
- session management
- password reset or OAuth

### User Profile Service

- profile metadata
- consent state
- preference history

### Image Service

- upload images
- generate signed URLs
- manage deletion
- store derived masks and thumbnails

### Comparison Service

- create sessions
- define comparison pairs
- collect votes
- compute summary statistics

### Friend Review Service

- create public review tokens
- validate review links
- collect reviewer votes
- enforce expiry and abuse controls

### Report Service

- aggregate self and friend votes
- compute tendency labels
- generate explanations

### AI Service

- optional image observation
- color harmony scoring
- future style recommendation

## Deployment Environments

- local
- staging
- production

## Security Requirements

- HTTPS only
- signed image URLs
- short-lived friend review tokens
- rate limits on public review endpoints
- strict CORS
- consent-gated image processing
- user-controlled deletion

## Data Retention

Default recommendation:

- Store raw images only with explicit consent.
- Store derived comparison decisions and anonymized metadata for product improvement.
- Provide delete-my-data functionality.
