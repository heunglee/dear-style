# Android Spec

## Stack

Preferred:

- JDK 17
- Android Gradle Plugin 9.2.x
- Gradle 9.4.x
- Kotlin 2.4.x
- Android SDK compileSdk 36
- Android SDK targetSdk 36
- Jetpack Compose with the latest stable Compose BOM
- CameraX for camera flows
- Retrofit/OkHttp
- Room optional for local drafts

## Screens

- HomeActivity
- CoachingTargetActivity
- SelfieCaptureActivity
- CoachingResultActivity
- MirrorModeActivity
- FeedbackUploadActivity
- ReportActivity

## Coaching Overlay

Implement overlay rendering with Compose.

Responsibilities:

- draw points, lines, curves, and regions
- render step guidance
- show image quality and confidence warnings
- normalize coordinates
- send image and coaching requests to backend
- display feedback

## Mirror Mode

Use front camera preview with checklist overlay. Avoid precision AR promises in MVP.

## Offline Behavior

Pending coaching or feedback submissions may be saved locally and uploaded later.
