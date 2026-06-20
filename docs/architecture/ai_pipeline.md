# AI Pipeline

## Makeup Coaching Pipeline

```text
Image
  ↓
Quality Validation
  ↓
Face Detection
  ↓
Landmark Detection
  ↓
Feature Extraction
  ↓
Geometry Analysis
  ↓
Coaching Strategy Generation
  ↓
Overlay Generation
  ↓
Feedback Generation
  ↓
QA Confidence Review
```

## Agent Ownership

- QA Agent: quality validation and confidence review
- Face Analysis Agent: face detection, landmark detection, feature extraction, geometry analysis
- Makeup Coach Agent: coaching strategy, overlay generation, feedback generation
- Recommendation Agent: style, occasion, and product category recommendations

## Output Contract

The pipeline should return:

- detected facial regions
- normalized landmarks
- geometry measurements
- coaching instructions
- overlay primitives
- confidence score
- warnings or failure reasons
