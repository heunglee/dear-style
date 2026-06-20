# Landmark Detection Spec

## Purpose

Define the facial regions required by the Face Analysis Agent.

## Eyes

- eyelid
- inner corner
- outer corner
- lower lid reference

## Eyebrows

- head
- arch
- tail
- upper edge
- lower edge

## Nose

- bridge
- tip
- nostril boundaries

## Lips

- cupid bow
- upper contour
- lower contour
- corners
- center line

## Cheeks

- cheekbone region
- apple of cheek estimate
- blush-safe blending region

## Face Shape

- jaw
- cheekbones
- forehead
- chin

## Coordinate Requirements

- Coordinates must be normalized to image width and height.
- Missing landmarks must be represented explicitly.
- Each region should carry a confidence score when available.
