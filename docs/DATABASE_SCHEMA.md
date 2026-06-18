# Database Schema

## Notes

Use PostgreSQL. UUID primary keys are recommended.

## Tables

### users

- id UUID PK
- email TEXT UNIQUE NOT NULL
- password_hash TEXT NULL
- display_name TEXT NULL
- created_at TIMESTAMPTZ NOT NULL
- updated_at TIMESTAMPTZ NOT NULL

### user_consents

- id UUID PK
- user_id UUID FK users.id
- consent_type TEXT NOT NULL
- granted BOOLEAN NOT NULL
- version TEXT NOT NULL
- created_at TIMESTAMPTZ NOT NULL

Consent types:

- face_image_upload
- raw_image_storage
- friend_review_sharing
- anonymized_analytics

### image_assets

- id UUID PK
- user_id UUID FK users.id
- storage_key TEXT NOT NULL
- asset_type TEXT NOT NULL
- width INT NULL
- height INT NULL
- mime_type TEXT NOT NULL
- raw_image BOOLEAN NOT NULL DEFAULT TRUE
- consent_id UUID FK user_consents.id NULL
- created_at TIMESTAMPTZ NOT NULL
- deleted_at TIMESTAMPTZ NULL

Asset types:

- original_face
- thumbnail
- face_mask
- rendered_comparison

### comparison_sessions

- id UUID PK
- user_id UUID FK users.id
- image_asset_id UUID FK image_assets.id
- session_type TEXT NOT NULL
- status TEXT NOT NULL
- environment_label TEXT NULL
- created_at TIMESTAMPTZ NOT NULL
- completed_at TIMESTAMPTZ NULL

Session types:

- color_harmony_undertone
- lip_color
- eyewear
- clothing_color
- eyeliner_shape
- lip_shape

### comparison_pairs

- id UUID PK
- session_id UUID FK comparison_sessions.id
- pair_key TEXT NOT NULL
- option_a_label TEXT NOT NULL
- option_b_label TEXT NOT NULL
- option_a_payload JSONB NOT NULL
- option_b_payload JSONB NOT NULL
- sort_order INT NOT NULL

Examples:

- gold_vs_silver
- ivory_vs_pure_white
- camel_vs_cool_grey
- coral_vs_rose

### reviews

- id UUID PK
- session_id UUID FK comparison_sessions.id
- reviewer_type TEXT NOT NULL
- reviewer_alias TEXT NULL
- reviewer_token TEXT NULL
- created_at TIMESTAMPTZ NOT NULL

Reviewer types:

- self
- friend
- ai

### review_votes

- id UUID PK
- review_id UUID FK reviews.id
- comparison_pair_id UUID FK comparison_pairs.id
- selected_option TEXT NOT NULL
- prompt_key TEXT NOT NULL
- confidence INT NULL
- created_at TIMESTAMPTZ NOT NULL

Selected option:

- A
- B
- TIE
- UNSURE

Prompt keys:

- healthier
- natural
- brighter
- harmonious
- polished

### friend_review_links

- id UUID PK
- session_id UUID FK comparison_sessions.id
- token_hash TEXT NOT NULL
- expires_at TIMESTAMPTZ NOT NULL
- max_reviews INT NULL
- created_at TIMESTAMPTZ NOT NULL
- disabled_at TIMESTAMPTZ NULL

### reports

- id UUID PK
- user_id UUID FK users.id
- session_id UUID FK comparison_sessions.id
- report_type TEXT NOT NULL
- summary JSONB NOT NULL
- generated_at TIMESTAMPTZ NOT NULL

### products

- id UUID PK
- brand TEXT NOT NULL
- name TEXT NOT NULL
- category TEXT NOT NULL
- shade_name TEXT NULL
- color_hex TEXT NULL
- undertone_tag TEXT NULL
- brightness_tag TEXT NULL
- saturation_tag TEXT NULL
- metadata JSONB NOT NULL DEFAULT '{}'
- created_at TIMESTAMPTZ NOT NULL

### recommendation_events

- id UUID PK
- user_id UUID FK users.id
- report_id UUID FK reports.id NULL
- product_id UUID FK products.id NULL
- recommendation_type TEXT NOT NULL
- reason JSONB NOT NULL
- created_at TIMESTAMPTZ NOT NULL

## Indexes

- users.email unique
- image_assets.user_id
- comparison_sessions.user_id
- comparison_pairs.session_id
- reviews.session_id
- review_votes.review_id
- friend_review_links.token_hash unique
- reports.user_id
- products.category
- products.undertone_tag
