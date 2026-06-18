# Appearance Design Ontology

## Purpose

Model relationships between facial features, drawing techniques, user goals, impressions, practice behavior, and products.

## Node Types

- Person
- FacialFeature
- EyeShape
- FaceShape
- MakeupLine
- DrawingTechnique
- PracticeTemplate
- Impression
- Lesson
- Product
- Review
- EventContext

## Relationship Types

Person PRACTICES DrawingTechnique

DrawingTechnique USES MakeupLine

MakeupLine CREATES Impression

EyeShape MODIFIES DrawingTechnique

FaceShape MODIFIES DrawingTechnique

EventContext PREFERS Impression

Product SUPPORTS DrawingTechnique

Review EVALUATES ApplicationResult

Person PREFERS Impression

## Example

```text
Person
→ wants → Professional Impression
→ learns → Natural Tightline
→ practices → Thin Lashline Template
→ applies → Before/After Result
→ receives → Friend Review
```

## Color Ontology Position

Color nodes may exist, but undertone should not be treated as a definitive inferred identity from uncontrolled photos. Use color features for preference and education first.
