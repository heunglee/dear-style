# iOS Spec

## Stack

- Xcode 26.4.1 or newer stable
- Swift 6.3.x from stable Xcode
- iOS 26 SDK from stable Xcode
- Minimum iOS 17+ initially
- SwiftUI
- AVFoundation
- URLSession or Alamofire optional
- CoreData optional for local drafts

## Screens

- HomeView
- CoachingTargetView
- SelfieCaptureView
- CoachingResultView
- MirrorModeView
- FeedbackUploadView
- ReportView

## Coaching Overlay

Use SwiftUI Canvas or custom UIViewRepresentable drawing view.

Render:

- points
- lines
- curves
- regions
- confidence warnings

## Mirror Mode

Use AVFoundation front camera preview. Optional Apple Vision landmarks can be added later but are not required for MVP.

## Privacy

Explain camera and photo permissions clearly.
