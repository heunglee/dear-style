# Beauty Graph

## Purpose

Beauty Graph represents relationships between users, colors, style elements, impressions, events, and products.

It is a future system and should not block MVP delivery.

## Initial Implementation

Start with PostgreSQL tables and JSONB.

Do not introduce Neo4j or graph database infrastructure until traversal needs become complex.

## Node Types

- Person
- Color
- StyleElement
- Product
- Brand
- Impression
- EventContext
- Report
- Review

## Edge Types

- PREFERS
- AVOIDS
- SELECTED_OVER
- CREATES_IMPRESSION
- CONTAINS_COLOR
- SUPPORTS_STYLE
- RECOMMENDED_FOR
- USED_IN_CONTEXT

## Example

Person PREFERS MutedCoral
MutedCoral CREATES_IMPRESSION Natural
Natural USED_IN_CONTEXT DailyLook
Product CONTAINS_COLOR MutedCoral

## Future Queries

- Which products match this user’s repeated color preferences?
- Which styles create a professional impression for this user?
- Which shade gaps exist among neutral-warm users who prefer muted lip colors?
