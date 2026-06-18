# Android Spec

## Stack

Preferred:

- Kotlin or Java-compatible architecture
- Jetpack Compose preferred if Kotlin is allowed
- CameraX
- Retrofit/OkHttp
- Room optional for local drafts

If Java is required:

- Android Views
- custom View for trace practice
- CameraX Java APIs

## Screens

- HomeActivity
- LessonListActivity
- LessonDetailActivity
- TracePracticeActivity
- MirrorModeActivity
- UploadResultActivity
- ReportActivity

## Trace Practice

Implement as a custom drawing view.

Responsibilities:

- draw target path
- capture user path
- normalize coordinates
- send to backend
- display score

## Mirror Mode

Use front camera preview with checklist overlay. Avoid precision AR promises in MVP.

## Offline Behavior

Practice attempts may be saved locally and uploaded later.
