# AI Pipeline

## MVP Principle

The MVP does not require full AI-driven face-tone classification.

The first useful intelligence comes from structured A/B comparison results.

## Data Inputs

- self votes
- friend votes
- comparison pair metadata
- optional AI visual observations
- lighting/environment labels
- repeat-session consistency

## MVP Scoring

### Pair Outcome

For each comparison pair:

- option A vote count
- option B vote count
- tie/unsure count
- self vs friend difference
- confidence average

### Tendency Mapping

Example:

- Gold > Silver contributes warm tendency.
- Ivory > Pure White contributes warm tendency.
- Camel > Cool Grey contributes warm tendency.
- Silver > Gold contributes cool tendency.
- Pure White > Ivory contributes cool tendency.
- Cool Grey > Camel contributes cool tendency.

### Confidence

Confidence should be based on:

- number of completed comparisons
- vote consistency
- repeated test consistency across environments
- friend review count
- tie/unsure rate

## Example Output

```json
{
  "undertone_tendency": "neutral_warm",
  "confidence": 0.72,
  "evidence": [
    "Gold selected over Silver in 2 of 3 sessions",
    "Ivory selected over Pure White by 70% of friend reviewers"
  ]
}
```

## Optional Image AI

Image AI can assist with:

- face detection
- face crop validation
- overlay placement
- approximate lighting quality detection
- obvious filter warning

Image AI should not be the primary source of undertone truth in MVP.

## Future AI Capabilities

### Makeup Shape Recognition

Estimate facial landmarks to place eyeliner, brows, and lip-line overlays.

### Impression Engine

Map style combinations to impression labels.

Example:

- soft brown eyeliner + muted rose lip → natural, approachable
- black cat eye + sharp lip line → bold, polished

### Recommendation Engine

Use reports and product metadata to suggest products.

### Beauty Graph Reasoning

Traverse relationships:

User → preferred colors → impressions → products → routines
