# Android Specification

## Stack

Preferred:

- Kotlin
- Jetpack Compose
- Retrofit or Ktor client
- Coil for image loading
- Room only if offline cache is needed

Acceptable alternative:

- Java with XML views if project constraints require it

## Permissions

- Camera
- Photo picker

Use Android Photo Picker where possible to reduce permission burden.

## Screens

- WelcomeActivity / WelcomeScreen
- ConsentScreen
- UploadScreen
- TestSelectionScreen
- ComparisonScreen
- FriendShareScreen
- ReportScreen
- PrivacySettingsScreen

## Native Flows

### Capture / Upload

- Launch camera or photo picker.
- Show preview.
- Confirm consent before upload.
- Upload via signed URL.

### Comparison

- Display A/B images.
- Use large touch targets.
- Allow Tie / Unsure.
- Save votes locally until submitted.

### Share

Use Android Sharesheet for friend review link.

## API Layer

Create typed API client methods matching API_SPEC.md.

## Error Handling

Show user-friendly messages for:

- upload failure
- expired friend link
- missing consent
- network failure

## Android Acceptance Criteria

- Native user can upload image.
- Native user can complete a comparison session.
- Native user can share friend-review link.
- Native user can view report.
- UI follows shared design tokens.
