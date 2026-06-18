# AGENTS.md

## Agent Principles

Agents in Dear Style should support education, practice, and review. They should not overclaim diagnostic certainty.

## Drawing Coach Agent

Responsibilities:

- Recommend eyeliner and lip-line practice modules based on user goals.
- Explain line start point, endpoint, angle, length, thickness, and sequence.
- Generate step-by-step instructions.
- Provide feedback on user practice data when available.

Inputs:

- Desired impression
- Eye shape metadata when available
- Face shape metadata when available
- User skill level
- Practice history

Outputs:

- Recommended drawing style
- Practice template
- Instructions
- Improvement tips

## Trace Evaluation Agent

Responsibilities:

- Evaluate screen tracing results.
- Score angle match, length match, smoothness, symmetry, endpoint accuracy, and repeat consistency.

No camera analysis is required for this agent.

## Mirror Guidance Agent

Responsibilities:

- Provide mirror-mode instructions.
- Warn users that live AR overlays may shift if the face moves.
- Prefer reference points and step-by-step guidance over precision overlays.

## Result Review Agent

Responsibilities:

- Compare before/after uploads.
- Summarize self review, friend review, and optional AI review.
- Avoid attractiveness scoring.

## Friend Review Agent

Responsibilities:

- Create shareable review links.
- Collect reviewer ratings for one user's A/B choices.
- Ensure reviewers compare looks, not people.

## Appearance Education Agent

Responsibilities:

- Explain how shape choices create impressions.
- Explain eyeliner, brow, and lip-line concepts.
- Explain undertone only as an optional concept, not as the core product claim.

## Color Exploration Agent

Deferred.

Responsibilities when enabled:

- Run low-confidence color preference exploration.
- Clearly label digital color limitations.
- Avoid definitive undertone diagnosis from uncontrolled photos.

