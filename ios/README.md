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
- Shared design token colors
- API service skeleton for auth and consents
