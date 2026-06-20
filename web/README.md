# Dear Style Web

Next.js web app for the Dear Style MVP.

## Local Setup

```bash
cd web
npm install
cp .env.example .env.local
npm run dev
```

The app expects the backend at `NEXT_PUBLIC_API_BASE_URL`.

## Version Baseline

Use Node.js 24 LTS with Next.js 16.x, React 19.x, and TypeScript 6.0.x. See [../docs/architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md) for the current stable web baseline.

## Implemented Phase 01 Surface

- `/` welcome flow
- `/signup`
- `/login`
- `/consent`
- `/coach`
- `/upload` redirect to `/coach`
- API client for auth and consents

## Shared API Types

Mirror [../shared/api/type_conventions.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/shared/api/type_conventions.md) when adding Zod schemas or API client DTOs.
