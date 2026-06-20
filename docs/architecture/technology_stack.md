# Technology Stack Versions

Last reviewed: 2026-06-20.

Use current stable releases for new work. If a dependency requires a compatibility hold, document the reason in this file and in the platform-specific README.

## Backend

| Component | Target version | Notes |
| --- | --- | --- |
| Python | 3.14.6 | Use the latest Python 3.14 bugfix release. Python 3.15 is pre-release and should not be used for production work yet. |
| FastAPI | 0.138.0 | Keep on the latest stable FastAPI release compatible with Python 3.14. |
| PostgreSQL | 18.4 | Use the latest PostgreSQL 18 stable minor release for local and production databases. PostgreSQL 19 is beta and not for production. |
| SQLAlchemy | 2.0.51 | Stay on SQLAlchemy 2.x. |
| Alembic | 1.18.4 | Match the SQLAlchemy 2.x ecosystem. |
| Psycopg | 3.3.4 | Use Psycopg 3, preferably `psycopg[binary]` for local development. |
| pydantic-settings | 2.14.2 | Keep aligned with Pydantic v2. |
| python-multipart | 0.0.32 | Required for file upload endpoints. |
| Uvicorn | 0.49.0 | Use `uvicorn[standard]` for local development. |
| pytest | 9.1.1 | Test runner. |
| Ruff | 0.15.18 | Lint and format tool. |
| HTTPX | 0.28.1 | Test client and outbound HTTP client when needed. |

## Web

| Component | Target version | Notes |
| --- | --- | --- |
| Node.js | 24.17.0 LTS | Use Active LTS for development and CI. Node 26 is current but not LTS. |
| npm | bundled with Node 24 LTS | Prefer npm unless the project explicitly changes package managers. |
| Next.js | 16.2.9 | Requires Node `>=20.9.0`; Node 24 LTS satisfies this. |
| React | 19.2.7 | Use the same version for `react` and `react-dom`. |
| TypeScript | 6.0.x | Use the latest stable TypeScript major unless Next.js guidance requires a compatibility hold. |
| ESLint | 9.x | Keep `eslint-config-next` on the matching Next.js major. |
| TanStack React Query | 5.x | Current app data-fetching cache. |
| MediaPipe Tasks Vision | 0.10.x | Optional browser-side vision helper; backend/service vision remains replaceable. |
| Zod | 4.x | Prefer Zod 4 for new schemas; migrate existing Zod 3 usage deliberately. |

## Android

| Component | Target version | Notes |
| --- | --- | --- |
| JDK | 17 | Required by Android Gradle Plugin 9.2. |
| Android Gradle Plugin | 9.2.0 | Latest stable AGP reviewed for this project. |
| Gradle | 9.4.1 | Required/default Gradle version for AGP 9.2. |
| Kotlin | 2.4.0 | Latest stable Kotlin language release reviewed for this project. |
| Android SDK compileSdk | 36 | Android 16 stable SDK. AGP 9.2 supports up to API 37, but API 37 should wait until stable platform release. |
| Android SDK targetSdk | 36 | Match compile SDK unless store policy or release timing requires otherwise. |
| minSdk | 26 | Keep unless product requirements require older device support. |
| Compose BOM | latest stable AndroidX Compose BOM | Check AndroidX release notes before implementation updates. |
| Activity Compose | latest stable AndroidX | Keep compatible with the selected Compose BOM. |
| Lifecycle Runtime KTX | latest stable AndroidX | Keep compatible with the selected Compose BOM. |
| kotlinx.serialization | latest stable | Keep aligned with the selected Kotlin version. |

## iOS

| Component | Target version | Notes |
| --- | --- | --- |
| Xcode | 26.4.1 or newer stable | Use the latest stable Xcode available from Apple, not beta/RC builds for release work. |
| Swift | Xcode-bundled stable Swift 6.3.x | Do not pin Swift separately unless CI uses a standalone toolchain. |
| iOS SDK | Xcode-bundled stable iOS 26 SDK | Use the SDK bundled with the selected stable Xcode. |
| Minimum iOS | iOS 17+ initially | Revisit after device analytics and camera/vision requirements are finalized. |
| SwiftUI | Xcode-bundled | Primary UI framework. |
| AVFoundation | Xcode-bundled | Camera and mirror flows. |
| Apple Vision | Xcode-bundled | Optional local landmark/vision integration. |

## Version Policy

- Prefer latest stable releases over preview, beta, RC, or EOL versions.
- Keep runtime versions explicit in README files and CI.
- Update lockfiles and project manifests in the same PR when implementation dependencies are upgraded.
- Re-run backend tests, web lint/typecheck/build, and platform builds after dependency upgrades.

## Manifest Updates Needed

The documentation baseline above is newer than some implementation manifests. When the dependency upgrade work begins, update these files together:

- `web/package.json`: Next.js 15.x range, TypeScript 5.x range, Zod 3.x range, and related lockfile entries should move to the web baseline.
- `android/build.gradle.kts`: Android Gradle Plugin 8.7.2 and Kotlin 2.0.21 should move to the Android baseline.
- `android/app/build.gradle.kts`: `compileSdk` 35, `targetSdk` 35, and Compose BOM `2024.10.01` should move to the Android baseline.
- `backend/pyproject.toml`: dependency lower bounds are broad; consider raising them when the backend upgrade is tested.
