# Mobile Shared Specification

## Shared Mobile Goals

Android and iOS should provide equivalent core flows:

- consent
- image capture/upload
- test selection
- A/B comparison
- self review
- friend link sharing
- report viewing
- privacy settings

## Platform-Specific Guidelines

Use native photo/camera APIs.

Use native share sheets.

Respect each platform's permission model.

## Offline Behavior

MVP does not require offline mode.

However, clients may temporarily store unsent votes until submission.

## Image Handling

- Resize client-side before upload if needed.
- Preserve enough resolution for face and overlay rendering.
- Avoid storing images in local persistent storage unless necessary.

## Analytics

Track only privacy-safe events:

- test started
- test completed
- report viewed
- friend link created
- recommendation clicked

Do not track raw facial attributes as analytics events.
