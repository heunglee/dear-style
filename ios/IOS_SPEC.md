# iOS Specification

## Stack

- Swift
- SwiftUI
- URLSession or Alamofire
- PhotosUI
- AVFoundation if camera capture is needed

## Permissions

- Photo Library limited access
- Camera access only when needed

Use native iOS permission explanations.

## Screens

- WelcomeView
- ConsentView
- UploadView
- TestSelectionView
- ComparisonView
- FriendShareView
- ReportView
- PrivacySettingsView

## Native Flows

### Photo Selection

Use PhotosPicker for user-selected images.

### Camera

Use camera capture only after explicit user action.

### Upload

- Request upload URL.
- Upload directly to signed URL.
- Confirm upload with backend.

### Share

Use UIActivityViewController or ShareLink.

## Data Layer

Create API service layer with typed DTOs.

## iOS Acceptance Criteria

- User can complete Color Harmony Test.
- User can generate and share friend-review link.
- User can view report.
- User can manage/delete image data.
- UI follows shared design tokens.
