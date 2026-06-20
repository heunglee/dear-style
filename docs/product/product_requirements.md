# Product Requirements

## Product Name

Dear Style

## Parent Brand

Dear Daughter Beauty

## Product Category

AI makeup coach, facial geometry guidance system, and appearance design learning platform.

## MVP Goal

Help users understand where and how to apply makeup on their own face using landmark-based guidance and gentle correction feedback.

## Non-Goals for MVP

- Definitive undertone diagnosis
- High-fidelity virtual try-on
- Gold/silver diagnostic scoring
- Clothing or eyewear AR compositing
- Product sales optimization
- Attractiveness scoring
- Public beauty ranking
- Medical or dermatological diagnosis

## Core User Flow

1. User uploads or captures a selfie.
2. QA Agent validates image quality.
3. Face Analysis Agent extracts landmarks and facial geometry.
4. User chooses a coaching target: lip line, eyebrow, blush, or feedback.
5. Makeup Coach Agent generates placement guidance and overlay primitives.
6. User applies makeup using the guidance.
7. User uploads before/after images when feedback is desired.
8. System summarizes improvements, limitations, and next steps.

## Initial Coaching Targets

### Lip Line Coach

Must provide:

- recommended outline
- overline or correction suggestion when appropriate
- asymmetry correction notes
- step-by-step application guide

### Eyebrow Coach

Must provide:

- start point
- arch point
- tail point
- shape and fill guidance

### Blush Placement Coach

Must provide:

- placement map
- application direction
- blending zone
- face-shape-aware cautions

### Makeup Feedback

Must provide:

- before/after comparison
- symmetry and placement observations
- improvement suggestions
- confidence and image quality notes

## Recommendation Scope

Initial recommendations should focus on strategy, not shopping:

- style recommendation
- occasion recommendation
- product category recommendation

Specific product recommendations are deferred until coaching quality is validated.

## Safety Requirements

The app must:

- explain low confidence when image quality is poor
- avoid attractiveness scoring
- avoid identity-level claims from makeup preferences
- allow users to delete face images
- make camera/photo usage clear

## Color Feature Position

Color harmony and undertone concepts may be included as educational or exploratory features only. The product should communicate that digital color analysis is limited without controlled lighting and real materials.
