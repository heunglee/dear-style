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

## FaceAnalysis

Structured output from the Face Analysis Agent.

Attributes:

- user_id
- source_image_id
- facial_regions
- landmarks
- geometry_measurements
- confidence_score
- warnings

## CoachingSession

A single makeup coaching request.

Attributes:

- user_id
- goal
- target_area: lip_line, eyebrow, blush, full_feedback
- face_analysis_id
- status
- created_at

## CoachingGuide

Actionable guidance generated for a coaching session.

Attributes:

- coaching_session_id
- guide_type
- instructions
- overlay_primitives
- correction_feedback
- confidence_score

## StyleLesson

A reusable lesson for a makeup technique. Deferred until the coaching MVP needs structured education content.

Attributes:

- category: lip_line, eyebrow, blush, color_exploration
- name
- target_impressions
- difficulty
- instructions
- common_mistakes

## DrawingTemplate

A target shape used for future trace practice.

Attributes:

- lesson_id
- geometry_type
- normalized_path
- reference_points
- scoring_rules

## PracticeSession

A user's future practice session.

Attributes:

- user_id
- lesson_id
- status
- started_at
- completed_at

## TraceAttempt

A future screen tracing attempt.

Attributes:

- practice_session_id
- input_path
- angle_score
- length_score
- smoothness_score
- endpoint_score
- total_score

## ApplicationResult

A real-world before/after result. Replaced in the MVP by FeedbackResult.

Attributes:

- user_id
- lesson_id
- before_image_id
- after_image_id
- notes

## ReviewSession

A future review link for guided feedback.

Attributes:

- application_result_id
- review_type
- share_token
- expires_at

## ReviewVote

A future review result.

Attributes:

- review_session_id
- reviewer_type
- selected_option
- impression_ratings
- comment_optional

## ColorExploration

Deferred feature for preference-based color learning, not diagnosis.

## FeedbackResult

Before/after coaching feedback.

Attributes:

- user_id
- before_image_id
- after_image_id
- target_area
- observations
- improvement_suggestions
- confidence_score

## Recommendation

Style, occasion, and product category strategy.

Attributes:

- user_id
- face_analysis_id
- occasion
- style_goal
- strategy
- product_categories
- confidence_score
