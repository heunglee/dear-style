# Dear Style Documentation

This directory is the source of truth for the v2 pivot.

## Sections

- `product/`: vision, MVP scope, personas, roadmap, and user stories
- `architecture/`: system boundaries, API contracts, database schema, privacy, and implementation notes
- `ux/`: user flows, mobile guidance, design system, and accessibility
- `ai/`: landmark detection, face analysis, makeup coaching, and recommendation behavior
- `tasks/`: implementation phases

## Current Product Direction

Dear Style is an AI makeup coaching platform. The MVP focuses on face-geometry-based guidance for lip line, eyebrows, blush placement, and before/after feedback.

Color diagnosis, virtual try-on, trace practice, friend review, and specific product recommendation are deferred unless a later phase explicitly reintroduces them.

## Documentation Alignment Baseline

Use these documents as the current source of truth for the v2 pivot:

1. `product/pivot_decision.md` defines why the product moved away from color diagnosis and toward coaching.
2. `product/product_requirements.md` defines MVP scope, non-goals, safety requirements, and recommendation scope.
3. `architecture/system_architecture.md` and `architecture/ai_pipeline.md` define agent boundaries and execution flow.
4. `tasks/phase_01_foundation.md` defines the first implementation phase and its acceptance criteria.

When documents disagree, prefer the coaching-first MVP definition: actionable placement guidance, confidence-aware face analysis, before/after feedback, and deferred color or product-specific features.

## Version Baseline

Use [architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md) as the canonical version baseline for runtimes, frameworks, libraries, and databases.
