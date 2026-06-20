# Face Analysis

## Responsibility

The Face Analysis Agent turns a validated face image into structured facial geometry.

## Inputs

- image_id
- image dimensions
- optional capture metadata

## Outputs

- face bounding box
- facial regions
- normalized landmarks
- symmetry measurements
- feature localization
- confidence score
- warnings

## Geometry Scope

Initial regions:

- lips
- eyebrows
- cheeks
- eyes
- nose
- jaw and face outline

## Failure Modes

Return a low-confidence result or failure reason when:

- no face is detected
- multiple faces are present
- face is too small
- lighting is too low or uneven
- landmarks are incomplete
- occlusion blocks the target region
