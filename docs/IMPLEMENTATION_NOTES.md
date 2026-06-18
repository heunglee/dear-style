# Implementation Notes for Codex

## Do First

Implement the relational MVP before adding complex AI.

## Avoid Premature Complexity

Do not add:

- graph database
- vector database
- photorealistic try-on
- advanced ML training
- B2B dashboard

until the comparison and report system works.

## MVP Report Calculation

Start with deterministic scoring.

Example:

- warm score: gold, ivory, camel, coral selections
- cool score: silver, pure white, cool grey, rose selections
- neutral: close score or inconsistent results

## Test Data

Create seed comparison pairs and product examples.

## Quality Gates

Every phase must pass:

- backend tests
- API contract checks
- consent enforcement checks
- UI smoke tests

## Privacy Gates

Before production:

- verify signed URLs
- verify deletion
- verify expired friend links
- verify no public image leakage
