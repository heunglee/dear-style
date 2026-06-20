# Phase 02 — Landmark and Geometry MVP

## Goal

Implement the first Face Analysis Agent surface.

## Tasks

- Add image upload metadata.
- Add face_analyses table and API.
- Add image quality validation.
- Add face detection adapter interface.
- Add landmark detection adapter interface.
- Store normalized landmarks and facial regions.
- Return geometry confidence and warnings.

## Acceptance Criteria

- A selfie can be uploaded and associated with a user.
- Face analysis returns structured geometry or a clear failure reason.
- Low-quality images produce QA warnings instead of confident coaching.
