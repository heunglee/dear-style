# System Architecture

## Overview

Dear Style v2 is a cross-platform application with a shared backend, responsive web app, Android app, and iOS app.

The MVP should emphasize structured content, deterministic practice scoring, image upload, and review flows. AI/vision modules should be isolated behind interfaces so the platform can evolve without blocking the initial release.

## Components

```text
Web App
Android App
 iOS App
    ↓
API Gateway / FastAPI Backend
    ↓
PostgreSQL
Object Storage
Optional Job Queue
Optional Vision Service
```

## Backend

Responsibilities:

- authentication
- user profile management
- lesson catalog APIs
- drawing template APIs
- practice session APIs
- trace attempt scoring
- image upload metadata
- review links and votes
- report generation

## Web

Responsibilities:

- landing page
- account flow
- lesson browsing
- trace practice in browser canvas
- review pages for friends
- reports

## Android

Responsibilities:

- native lesson flow
- canvas trace practice
- camera/mirror mode
- image upload
- offline-friendly practice drafts

## iOS

Responsibilities:

- native lesson flow
- SwiftUI canvas trace practice
- camera/mirror mode
- image upload
- optional Apple Vision integration

## Vision Service

Deferred but interface-ready.

Potential features:

- face landmarks
- eye landmarks
- before/after alignment assistance
- basic shape hints

The MVP must not depend on this service for core value.

## Storage

Image files should be stored outside the relational database. Store only metadata and references in PostgreSQL.

## Privacy

Face images are sensitive. Default retention should be minimal. Users must be able to delete uploaded images.
