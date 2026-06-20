# Makeup Coaching

## Responsibility

The Makeup Coach Agent converts facial geometry into actionable makeup guidance.

## Coaching Targets

- lip line
- eyebrows
- blush placement
- before/after correction feedback

## Output Shape

Each guide should include:

- target_area
- goal
- step-by-step instructions
- overlay primitives
- common cautions
- confidence score
- warnings

## Copy Rules

Use specific, actionable language:

- "Start the brow slightly inside this point."
- "Blend upward and outward from the marked cheek area."
- "Keep the upper lip correction subtle near the corner."

Avoid judgmental language:

- "Your face shape is bad for this."
- "This makes you prettier."
- "You did this wrong."

## Overlay Primitives

Use simple structured primitives so clients can render consistently:

- point
- line
- curve
- region
- arrow
- label

Coordinates should be normalized to image dimensions.
