# Privacy and Safety

## Sensitive Data

Face images are sensitive personal data.

The system must minimize collection, retention, and exposure.

## Consent Requirements

Before face upload, ask for explicit consent for:

- face image upload
- raw image storage
- friend review sharing
- anonymized analytics

## Data Minimization

Recommended defaults:

- Store raw images only when needed.
- Prefer derived thumbnails and overlay coordinates.
- Delete expired public review assets.
- Use signed URLs.

## Friend Review Safety

Friend review prompts must not ask:

- Which version is prettier?
- Which person looks better?
- Who is more attractive?

Allowed prompts:

- Which option looks more harmonious?
- Which option looks more natural?
- Which option makes the face appear brighter?
- Which option looks more polished?

## Appearance Harm Avoidance

Do not rank users by beauty.

Do not generate body, age, race, ethnicity, or medical judgments.

Do not infer skin disease.

## Reporting Language

Use tendency-based language.

Preferred:

- Your results lean neutral-warm.
- Gold and ivory were repeatedly selected.
- The result is not final; retesting in different lighting can improve confidence.

Avoid:

- You are definitely warm tone.
- You should never wear silver.
- Your skin is bad with cool colors.

## Deletion

Users must be able to delete:

- uploaded images
- comparison sessions
- reports
- account data

## Abuse Controls

Public friend-review links require:

- token hashing
- expiry
- rate limiting
- max review count
- reporting/disable option
