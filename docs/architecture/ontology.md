# Appearance Design Ontology

## Purpose

Model relationships between facial features, geometry measurements, coaching strategies, feedback, user goals, and product categories.

## Node Types

- Person
- FacialFeature
- FacialRegion
- Landmark
- GeometryMeasurement
- EyeShape
- FaceShape
- MakeupLine
- CoachingGuide
- OverlayPrimitive
- Impression
- FeedbackResult
- ProductCategory
- EventContext

## Relationship Types

Person REQUESTS CoachingGuide

CoachingGuide TARGETS FacialFeature

CoachingGuide USES OverlayPrimitive

Landmark DEFINES FacialRegion

GeometryMeasurement INFORMS CoachingGuide

FaceShape MODIFIES CoachingGuide

EventContext SUGGESTS Impression

ProductCategory SUPPORTS CoachingGuide

FeedbackResult EVALUATES CoachingGuide

Person PREFERS Impression

## Example

```text
Person
→ wants → Soft Impression
→ uploads → Selfie
→ receives → Blush Placement Guide
→ applies → Before/After Result
→ receives → Feedback Result
```

## Color Ontology Position

Color nodes may exist, but undertone should not be treated as a definitive inferred identity from uncontrolled photos. Use color features for preference and education first.
