# Recommendation Engine

## Purpose

Convert Dear Style reports into practical beauty and fashion recommendations.

## MVP Status

Recommendation is not required for Phase 1 except simple next-test suggestions.

## Inputs

- report summary
- undertone tendency
- color family preferences
- self preference
- friend preference
- product catalog metadata
- event context, if provided

## Product Metadata

Each product should have:

- category
- shade name
- color family
- undertone tag
- brightness tag
- saturation tag
- finish
- coverage/intensity
- sensitive-skin suitability, if known

## Recommendation Types

- lip color
- foundation undertone guidance
- eyeliner color
- blush color
- eyewear frame color
- clothing color family

## Recommendation Explanation

Every recommendation should include a reason.

Example:

```text
Muted coral is recommended because coral options were repeatedly preferred over cool rose, and muted saturation performed better than bright saturation in your tests.
```

## Ranking Signals

- user self preference
- friend review preference
- consistency across sessions
- product metadata match
- context match
- previous user saves or dismissals

## Avoid

- attractiveness claims
- absolute guarantees
- medical or dermatological claims
