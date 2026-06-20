# Phase 01 — Foundation

## Goal

Create the repository foundation for Dear Style v2 and align all project documentation around the coaching pivot.

## Tasks

- Align product, architecture, UX, AI, and task docs around the v2 makeup coaching pivot.
- Initialize backend FastAPI project.
- Initialize web Next.js project.
- Add Android app skeleton.
- Add iOS app skeleton.
- Add PostgreSQL docker-compose.
- Add shared API type conventions.
- Add CI lint/test workflow.

## Acceptance Criteria

- Documentation consistently defines the MVP as face-geometry-based makeup coaching.
- Deferred color, virtual try-on, trace practice, friend review, and product catalog features are clearly marked as non-MVP.
- CI validates shared API contracts, backend lint/tests, web lint/typecheck/build, Android debug build, and iOS simulator build.
- Backend health endpoint works.
- Web home page works.
- Android app opens to home screen.
- iOS app opens to home screen.
- Database migrations run locally.

## Verification

Last verified locally:

- Shared API catalog parses and includes MVP coaching targets.
- Backend Ruff checks pass.
- Backend pytest suite passes.
- Alembic migrations apply to local PostgreSQL.
- Web lint, typecheck, and production build pass.
- Android debug build passes.
- iOS simulator build passes.
