# Implementation Notes

## Pivot Summary

The previous documentation emphasized color harmony, undertone testing, and line-tracing practice. The current v2 direction is AI-assisted makeup coaching based on facial landmarks and geometry.

## Why Pivot

Digital color testing has practical problems:

- material reflection is hard to simulate
- lighting changes results
- phone camera processing changes colors
- digital overlays can mislead users
- high-fidelity virtual try-on is costly

## New MVP Advantage

Lip line, eyebrow, blush, and before/after feedback are placement and geometry problems. They are more stable than uncontrolled digital color analysis and more directly actionable for users.

## Engineering Priority

Build:

1. image upload and consent flow
2. quality validation
3. face landmark extraction
4. facial geometry output
5. coaching session APIs
6. overlay and feedback output
7. confidence and safety checks

Do not build:

1. AR makeup rendering
2. undertone scoring
3. clothing virtual try-on
4. product recommender
5. friend review system
6. trace practice engine

until the core coaching loop is validated.
