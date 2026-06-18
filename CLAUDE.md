# CLAUDE.md

## Project Identity

You are working on Dear Style, a Dear Daughter Beauty service for color harmony, undertone analysis, makeup shape discovery, fashion color guidance, and product recommendation.

## Development Philosophy

Build a reliable visual comparison platform first. Do not overbuild AI classification before the comparison and review loops work.

The MVP must support:

- A/B comparison sessions
- Color overlays
- Friend review links
- Result aggregation
- Explainable reports

## Critical Product Rule

The system should avoid deterministic identity claims such as:

- "You are Warm Tone."
- "You are Cool Tone."
- "This color is objectively best for you."

Use tendency-based language:

- "Your repeated results lean warm-neutral."
- "Gold was selected more often than Silver."
- "Muted coral received stronger friend feedback than cool rose."

## Safety Rule

Never rank people by beauty, attractiveness, or physical worth.

The system evaluates:

- color harmony
- styling compatibility
- perceived impression
- preference patterns

It does not evaluate:

- beauty
- attractiveness
- race or ethnicity
- medical skin condition

## Engineering Constraints

- Keep image processing modular.
- Store original face images only when explicitly consented.
- Prefer derived assets and masks over raw image retention.
- Use signed URLs for image access.
- Separate public friend-review access from authenticated user access.
- Keep all AI outputs explainable and inspectable.

## Naming

Product: Dear Style
Parent brand: Dear Daughter Beauty
Primary feature name: Color Harmony Test (Undertone Analysis)

## Implementation Order

1. Backend schema and auth
2. Image upload and storage
3. A/B comparison model
4. Web MVP
5. Friend review flow
6. Result report
7. Mobile parity
8. AI-assisted analysis
9. Recommendations
10. Beauty Graph
