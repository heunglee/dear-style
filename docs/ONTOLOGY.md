# Dear Style Ontology

## Purpose

The ontology defines stable concepts for future Beauty Graph development.

## Core Classes

### Person

A user or anonymous reviewer subject.

### Color

A color or color family.

Properties:

- hex
- hue_family
- warmth
- brightness
- saturation
- opacity

### UndertoneTendency

Values:

- warm
- cool
- neutral
- neutral_warm
- neutral_cool
- inconclusive

### StyleElement

Examples:

- eyeliner
- brow
- lip_line
- eyewear_frame
- clothing_top

### Product

Examples:

- lipstick
- foundation
- eyeliner
- blush
- eyewear

### Impression

Examples:

- natural
- friendly
- elegant
- polished
- sophisticated
- professional
- bold

### EventContext

Examples:

- interview
- wedding_guest
- daily
- date
- dinner

## Relationships

Person PREFERS Color

Person AVOIDS Color

Person PREFERS StyleElement

Color SUPPORTS UndertoneTendency

Color CREATES Impression

StyleElement CREATES Impression

Product CONTAINS Color

Product SUPPORTS StyleElement

EventContext REQUIRES Impression

Impression ASSOCIATED_WITH Color

Impression ASSOCIATED_WITH StyleElement

## Example Graph

Interview → REQUIRES → Professional
Professional → ASSOCIATED_WITH → Muted Rose
Professional → ASSOCIATED_WITH → Soft Brown Eyeliner
User → PREFERS → Muted Rose
Product → CONTAINS → Muted Rose

## Implementation Note

Do not introduce graph database infrastructure during MVP unless needed.

Start with relational tables and JSONB. Add graph storage later if query complexity justifies it.
