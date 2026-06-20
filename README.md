# Dear Style

Dear Style is a Dear Daughter Beauty service focused on **AI-assisted makeup coaching**.

The product helps users answer:

```text
How should I apply makeup on my own face?
```

The current pivot moves the project away from product-first color matching and toward face-geometry-based guidance:

1. Analyze facial landmarks and visible feature geometry.
2. Recommend placement and shape strategies.
3. Generate makeup application guides and overlays.
4. Review before/after results and provide correction feedback.

## Primary MVP Direction

- Lip line coach
- Eyebrow coach
- Blush placement coach
- Before/after makeup feedback

## Agent Architecture

The product is organized around the agents defined in [AGENTS.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/AGENTS.md):

- Face Analysis Agent
- Makeup Coach Agent
- Recommendation Agent
- QA Agent

## Documentation

- Product docs: [docs/product](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/product)
- Architecture docs: [docs/architecture](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture)
- Technology stack: [docs/architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md)
- UX docs: [docs/ux](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/ux)
- AI docs: [docs/ai](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/ai)
- Phase tasks: [docs/tasks](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/tasks)
- Shared API conventions: [shared/api/type_conventions.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/shared/api/type_conventions.md)

## Local Services

Start PostgreSQL and Redis for local development:

```bash
make dev-up
```

The backend default `DATABASE_URL` points at the `dearstyle` PostgreSQL database from `docker-compose.yml`.

## Technology Targets

- Backend: Python 3.14.6, FastAPI 0.138.x, PostgreSQL 18.4, SQLAlchemy 2.0.x, Alembic 1.18.x
- Web: Node.js 24 LTS, Next.js 16.x, React 19.x, TypeScript 6.0.x
- Android: JDK 17, Android Gradle Plugin 9.2.x, Gradle 9.4.x, Kotlin 2.4.x, Android SDK 36
- iOS: Xcode 26.4.1+ stable, Swift 6.3.x, iOS 26 SDK
- Vision: MediaPipe, ML Kit, Apple Vision, or a replaceable vision service
- Storage: local dev storage, S3-compatible production storage
