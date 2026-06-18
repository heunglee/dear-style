# AGENTS.md

## Purpose

This file defines AI-assisted development and runtime agents for Dear Style.

## Development Agents

### Product Spec Agent

Responsibilities:

- Maintain product intent consistency.
- Prevent scope creep away from comparison-based style discovery.
- Ensure features map to documented milestones.

### Backend Agent

Responsibilities:

- Implement FastAPI services.
- Maintain PostgreSQL schema.
- Implement auth, image upload, comparison sessions, reviews, and reports.
- Enforce privacy and consent rules.

### Web Agent

Responsibilities:

- Implement Next.js user flows.
- Build responsive comparison UI.
- Support shareable friend review pages.
- Implement report visualization.

### Android Agent

Responsibilities:

- Implement native Android capture, upload, A/B comparison, and review flows.
- Keep UI consistent with design tokens.
- Use platform-native permissions and privacy messaging.

### iOS Agent

Responsibilities:

- Implement native iOS capture, upload, A/B comparison, and review flows.
- Use SwiftUI and platform-native permission flows.
- Keep UI consistent with design tokens.

### QA Agent

Responsibilities:

- Verify cross-platform feature parity.
- Test image upload, review link expiry, consent, and report calculations.
- Prevent regressions in privacy-critical paths.

## Runtime Product Agents

### Color Analysis Agent

Responsibilities:

- Process A/B comparison results.
- Estimate undertone tendencies from repeated comparison patterns.
- Generate confidence and consistency scores.

Inputs:

- self votes
- friend votes
- AI-assisted image observations
- environment metadata

Outputs:

- warm/cool/neutral tendency
- color-family preferences
- confidence score
- explanatory report fragments

### Friend Review Agent

Responsibilities:

- Generate public review sessions.
- Collect reviewer choices.
- Prevent abusive or appearance-ranking prompts.
- Aggregate anonymous social preference patterns.

### Education Agent

Responsibilities:

- Explain undertone, brightness, saturation, contrast, and harmony.
- Convert technical terms into simple visual explanations.
- Avoid deterministic or exclusionary language.

### Style Shape Agent

Responsibilities:

- Explain how eyeliner, eyebrow, and lip line shapes influence perceived impression.
- Support future virtual try-on workflows.

### Recommendation Agent

Responsibilities:

- Recommend lip, foundation, eyeliner, eyewear, clothing colors, and future wardrobe combinations.
- Use user profile, preference history, and product catalog.
- Explain why a recommendation is made.

### Brand Insight Agent

Responsibilities:

- Aggregate anonymized preference data.
- Identify shade gaps.
- Support product development decisions.
- Never expose personally identifiable user data.
