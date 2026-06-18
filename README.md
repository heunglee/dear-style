# Dear Style — Development Documentation v2

Dear Style is a Dear Daughter Beauty service focused on **makeup drawing education, appearance design, and practice-based style discovery**.

This v2 documentation intentionally shifts the product away from an early emphasis on digital undertone/color diagnosis. Color harmony and undertone remain useful educational concepts, but they are no longer the primary MVP because digital color analysis is highly sensitive to lighting, camera processing, display calibration, material reflection, and synthetic compositing quality.

## Product Positioning

Dear Style helps users learn how to create desired impressions through makeup shape, especially eyeliner and lip-line technique.

Core loop:

```text
Choose impression goal
→ Learn recommended drawing style
→ Practice tracing the line on screen
→ Apply in front of mirror
→ Upload result
→ Self/friend/AI review
→ Improve with guided feedback
```

## Primary MVP

1. Eyeliner style guide
2. Eyeliner trace practice mode
3. Mirror-assisted application guide
4. Before/after review upload
5. Friend review for A/B result comparison
6. Impression prediction and education
7. Optional lip-line guide

## Deferred / Secondary

- Digital undertone testing
- Clothing/eyewear virtual try-on
- High-fidelity virtual makeup rendering
- Product recommendation
- Brand insight analytics

## Technology Targets

- Backend: Python FastAPI, PostgreSQL, SQLAlchemy, Alembic
- Web: Next.js / React / TypeScript
- Android: Native Android, Java or Kotlin-ready architecture
- iOS: Swift / SwiftUI
- Vision: MediaPipe/ML Kit/Apple Vision as optional modules
- Storage: local dev storage, S3-compatible production storage

