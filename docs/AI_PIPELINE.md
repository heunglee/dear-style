# AI and Scoring Pipeline

## MVP Principle

Use deterministic scoring before AI. The first product value comes from teaching and practice, not from complex AI inference.

## Trace Scoring

Input:

- target normalized path
- user input path

Scores:

- angle match
- length match
- endpoint accuracy
- smoothness
- consistency across attempts

Feedback examples:

- Tail angle is slightly too low.
- Line is close in length but uneven near the end.
- Endpoint is accurate; practice smoother pressure.

## Recommended Algorithm

1. Resample target and input paths to fixed number of points.
2. Normalize scale and coordinate space.
3. Calculate path distance using mean point distance.
4. Calculate angle difference between main stroke vectors.
5. Calculate length ratio.
6. Calculate endpoint distance.
7. Calculate smoothness using curvature variance.
8. Generate feedback from thresholds.

## Optional Vision Pipeline

Deferred.

Potential steps:

1. Detect face landmarks.
2. Detect eye landmarks.
3. Estimate eye shape category.
4. Suggest template scaling and placement.

Use only as guidance. Avoid medical or attractiveness claims.

## LLM Use

LLMs may be used for:

- generating educational explanations
- summarizing review comments
- converting scores into friendly feedback
- answering style questions

LLMs must not be used to produce unsupported certainty about undertone or attractiveness.

## Color Analysis Position

Color/undertone analysis is deferred and low-confidence unless capture is controlled. If implemented later, it should be framed as preference exploration, not diagnosis.
