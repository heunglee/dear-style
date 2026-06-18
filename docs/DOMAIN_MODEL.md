# Domain Model

## User

A person using Dear Style.

## Profile

Stores optional user preferences and skill metadata.

Attributes:

- skill_level
- preferred_impressions
- sensitive_skin_notes_optional
- privacy_settings

## Impression

A perceived style quality.

Examples:

- natural
- soft
- sharp
- lifted
- professional
- elegant
- bold
- friendly

## StyleLesson

A reusable lesson for a makeup technique.

Attributes:

- category: eyeliner, lip_line, brow, color_exploration
- name
- target_impressions
- difficulty
- instructions
- common_mistakes

## DrawingTemplate

A target shape used for trace practice.

Attributes:

- lesson_id
- geometry_type
- normalized_path
- reference_points
- scoring_rules

## PracticeSession

A user's learning session.

Attributes:

- user_id
- lesson_id
- status
- started_at
- completed_at

## TraceAttempt

A screen tracing attempt.

Attributes:

- practice_session_id
- input_path
- angle_score
- length_score
- smoothness_score
- endpoint_score
- total_score

## ApplicationResult

A real-world before/after result.

Attributes:

- user_id
- lesson_id
- before_image_id
- after_image_id
- notes

## ReviewSession

A review link for A/B evaluation.

Attributes:

- application_result_id
- review_type
- share_token
- expires_at

## ReviewVote

A self, friend, or AI review result.

Attributes:

- review_session_id
- reviewer_type
- selected_option
- impression_ratings
- comment_optional

## ColorExploration

Deferred feature for preference-based color learning, not diagnosis.
