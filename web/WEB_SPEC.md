# Web Spec

## Stack

- Next.js
- React
- TypeScript
- Canvas API
- Tailwind or CSS modules

## Routes

```text
/
/learn
/learn/[lessonSlug]
/practice/[lessonId]
/apply/[lessonId]
/results/[resultId]
/review/[shareToken]
/profile
```

## Key Components

- LessonCard
- ImpressionSelector
- StepGuide
- TraceCanvas
- PracticeScoreCard
- MirrorChecklist
- BeforeAfterUploader
- ReviewPrompt
- ReviewResults

## TraceCanvas Requirements

- render target path
- capture pointer events
- support mouse, touch, stylus
- resample points before API submission
- display scoring feedback

## Friend Review Page

Must be fast, mobile-first, and not require account login.

## Accessibility

- keyboard navigable lesson pages
- accessible labels
- high contrast line practice mode
