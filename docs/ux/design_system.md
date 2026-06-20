# Design System

## Brand Tone

Dear Style should feel:

- gentle
- precise
- educational
- non-judgmental
- polished

## Copy Rules

Use:

- "This creates a softer impression."
- "Try a shorter tail for a more natural look."
- "Your line is close. Practice smoother endings."

Avoid:

- "This makes you prettier."
- "Your face shape is bad for this."
- "You are definitely warm tone."

## Visual Style

- bright, clean, airy backgrounds
- soft blue, yellow, and pink brand accents
- high-contrast overlay lines for makeup guidance
- gentle accent color from Dear Daughter Beauty palette

## CSS Tokens

Use these CSS custom properties as the canonical web token set:

```css
:root {
  --brand-blue: #A8EBFF;
  --brand-yellow: #FFF8D6;
  --brand-pink: #FFC7DB;
  --hero-bg: #DBF3FB;
  --bg: #F7FAFC;
  --surface: #FFFFFF;
  --text: #17324D;
  --muted: #617082;
  --border: #E6EEF5;
}
```

## Semantic Usage

- `--brand-blue`: focus states, informational accents, cool overlay support
- `--brand-yellow`: soft highlight backgrounds and secondary callouts
- `--brand-pink`: primary brand accent and main action color
- `--hero-bg`: first-screen or coaching header background
- `--bg`: app/page background
- `--surface`: panels, forms, cards, and modal backgrounds
- `--text`: primary text
- `--muted`: secondary text and helper copy
- `--border`: dividers, input borders, and subtle outlines

## Coaching Overlays

Overlay lines, points, and regions should remain visually clear against uploaded photos. Do not rely on brand colors alone for critical guidance; pair color with labels, line style, or contrast.
