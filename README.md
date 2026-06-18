# Dear Style Development Documentation

Dear Style is an AI-assisted beauty, color, makeup-shape, and fashion discovery service under Dear Daughter Beauty.

The product helps users understand how color harmony, undertone tendencies, makeup shapes, eyewear, and clothing colors affect perceived appearance. The MVP prioritizes visual A/B comparison, friend review, and explainable reports over one-shot AI classification.

## Repository Purpose

This documentation package is designed for implementation with Codex, Claude Code, Cursor, or a human engineering team.

It defines:

- Product vision and requirements
- Technical architecture
- Backend API and data model
- Web, Android, and iOS implementation specs
- AI pipeline and recommendation architecture
- Privacy and safety constraints
- Milestone-based development tasks

## Core Product Principle

Do not classify users aggressively.

Prefer:

> Gold appeared more harmonious than Silver in repeated comparisons.

Avoid:

> You are Warm Tone.

Dear Style should teach users how to understand their own color and style reactions.

## Platform Targets

- Backend API
- Web app
- Android app
- iOS app
- Future AI/agentic recommendation layer

## Suggested Stack

- Backend: Python FastAPI
- Database: PostgreSQL
- Object Storage: S3-compatible storage
- Async Jobs: Celery or Dramatiq with Redis
- Web: Next.js / React / TypeScript
- Android: Kotlin preferred, Java acceptable if required
- iOS: Swift / SwiftUI
- AI Layer: modular services behind internal APIs

## Primary MVP Features

1. User account and consent flow
2. Face image upload
3. A/B comparison session
4. Color Harmony Test (Undertone Analysis)
5. Lip color test
6. Eyewear test
7. Clothing color test
8. Friend review via share link
9. Self vs friend preference aggregation
10. Explainable style report

## Secondary Expansion Features

1. Education system
2. Makeup shape simulation
3. Impression engine
4. Product matching
5. Beauty Graph
6. Brand insight dashboard
