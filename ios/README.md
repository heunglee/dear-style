# Dear Style iOS

Native iOS foundation for Dear Style.

## Local Setup

Open `DearStyle.xcodeproj` in Xcode, or build from the command line:

```bash
xcodebuild -project DearStyle.xcodeproj -scheme DearStyle -sdk iphonesimulator -configuration Debug build CODE_SIGNING_ALLOWED=NO
```

Phase 01 currently includes:

- Welcome view
- Consent view
- Coaching target view
- Shared design token colors
- API service skeleton for auth, consents, image upload, face analysis, coaching, feedback, and recommendations

## Shared API Types

Mirror [../shared/api/type_conventions.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/shared/api/type_conventions.md) when adding Codable request and response types.

## Version Baseline

Use the latest stable Xcode, Swift, and iOS SDK listed in [../docs/architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md). Avoid beta or RC toolchains for release work.
