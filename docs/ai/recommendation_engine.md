# Recommendation Engine

## Responsibility

The Recommendation Agent suggests style strategy, occasion strategy, and product categories.

## Inputs

- face_analysis_id
- user goal
- target area
- occasion
- preference history
- prior feedback themes

## Outputs

- recommended strategy
- reasoning
- caution notes
- product categories when relevant
- confidence score

## MVP Rules

- Recommend application strategy before products.
- Keep product output at category level.
- Explain uncertainty when geometry or image quality is weak.
- Do not infer sensitive traits.
- Do not rank attractiveness.

## Example Categories

- lip liner
- brow pencil
- brow gel
- cream blush
- powder blush
- blending brush
