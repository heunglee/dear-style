# Trace Scoring Spec

## Coordinate System

All target and input paths are normalized to a 0–1 coordinate space.

## Input Path Format

```json
[
  {"x": 0.12, "y": 0.44, "t": 1000},
  {"x": 0.13, "y": 0.44, "t": 1016}
]
```

## Scoring Dimensions

### Angle Score

Measures difference between target main vector and user main vector.

### Length Score

Measures path length ratio.

### Endpoint Score

Measures distance between target endpoint and user endpoint.

### Smoothness Score

Measures curvature variance and jitter.

### Total Score

Weighted average:

- angle: 30%
- length: 20%
- endpoint: 25%
- smoothness: 25%

Weights may be configured per template.

## Feedback Rules

- If angle score < 70: mention tail angle.
- If length score < 70: mention line too short or too long.
- If endpoint score < 70: mention endpoint placement.
- If smoothness score < 70: suggest slower, steadier stroke practice.
