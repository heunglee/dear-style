# Web App Specification

## Stack

- Next.js
- React
- TypeScript
- Tailwind CSS or CSS Modules
- TanStack Query for API data
- Zod for client validation

## Routes

- `/` welcome
- `/signup`
- `/login`
- `/consent`
- `/upload`
- `/tests`
- `/sessions/[sessionId]`
- `/sessions/[sessionId]/review`
- `/sessions/[sessionId]/share`
- `/reports/[reportId]`
- `/friend-review/[token]`
- `/settings/privacy`

## Key Components

### ComparisonView

Props:

- pairId
- optionA
- optionB
- promptKey
- onVote

### TestSelector

Lists available test types.

### UploadFaceImage

Handles upload, preview, and confirmation.

### FriendReviewPage

Public page with minimal branding and safe prompts.

### ReportSummary

Renders tendency, confidence, self/friend comparison, and evidence.

## State Management

Use server state via TanStack Query.

Local state only for:

- unsaved votes
- upload progress
- UI stepper state

## Rendering A/B Options

MVP may render overlays client-side using CSS/SVG/canvas.

If rendering quality becomes inconsistent, move rendering to backend image jobs.

## Web MVP Acceptance Criteria

- User can complete Color Harmony Test.
- User can submit self votes.
- User can generate friend review link.
- Friend can submit votes without account.
- User can view aggregated report.
- User can delete uploaded image.
