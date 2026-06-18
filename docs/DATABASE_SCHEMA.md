# Database Schema

PostgreSQL is the primary database.

## users

```sql
CREATE TABLE users (
  id UUID PRIMARY KEY,
  email TEXT UNIQUE NOT NULL,
  display_name TEXT,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## profiles

```sql
CREATE TABLE profiles (
  user_id UUID PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
  skill_level TEXT DEFAULT 'beginner',
  preferred_impressions JSONB DEFAULT '[]'::jsonb,
  privacy_settings JSONB DEFAULT '{}'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## style_lessons

```sql
CREATE TABLE style_lessons (
  id UUID PRIMARY KEY,
  category TEXT NOT NULL,
  slug TEXT UNIQUE NOT NULL,
  title TEXT NOT NULL,
  target_impressions JSONB NOT NULL DEFAULT '[]'::jsonb,
  difficulty TEXT NOT NULL DEFAULT 'beginner',
  description TEXT NOT NULL,
  instructions JSONB NOT NULL DEFAULT '[]'::jsonb,
  common_mistakes JSONB NOT NULL DEFAULT '[]'::jsonb,
  is_active BOOLEAN NOT NULL DEFAULT true,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## drawing_templates

```sql
CREATE TABLE drawing_templates (
  id UUID PRIMARY KEY,
  lesson_id UUID NOT NULL REFERENCES style_lessons(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  geometry_type TEXT NOT NULL,
  normalized_path JSONB NOT NULL,
  reference_points JSONB NOT NULL DEFAULT '{}'::jsonb,
  scoring_rules JSONB NOT NULL DEFAULT '{}'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## practice_sessions

```sql
CREATE TABLE practice_sessions (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  lesson_id UUID NOT NULL REFERENCES style_lessons(id),
  status TEXT NOT NULL DEFAULT 'started',
  started_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  completed_at TIMESTAMPTZ
);
```

## trace_attempts

```sql
CREATE TABLE trace_attempts (
  id UUID PRIMARY KEY,
  practice_session_id UUID NOT NULL REFERENCES practice_sessions(id) ON DELETE CASCADE,
  template_id UUID NOT NULL REFERENCES drawing_templates(id),
  input_path JSONB NOT NULL,
  angle_score NUMERIC(5,2),
  length_score NUMERIC(5,2),
  smoothness_score NUMERIC(5,2),
  endpoint_score NUMERIC(5,2),
  total_score NUMERIC(5,2),
  feedback JSONB NOT NULL DEFAULT '{}'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## media_assets

```sql
CREATE TABLE media_assets (
  id UUID PRIMARY KEY,
  user_id UUID REFERENCES users(id) ON DELETE SET NULL,
  storage_key TEXT NOT NULL,
  media_type TEXT NOT NULL,
  purpose TEXT NOT NULL,
  metadata JSONB NOT NULL DEFAULT '{}'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  deleted_at TIMESTAMPTZ
);
```

## application_results

```sql
CREATE TABLE application_results (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  lesson_id UUID NOT NULL REFERENCES style_lessons(id),
  before_image_id UUID REFERENCES media_assets(id),
  after_image_id UUID REFERENCES media_assets(id),
  user_notes TEXT,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## review_sessions

```sql
CREATE TABLE review_sessions (
  id UUID PRIMARY KEY,
  application_result_id UUID NOT NULL REFERENCES application_results(id) ON DELETE CASCADE,
  share_token TEXT UNIQUE NOT NULL,
  prompt TEXT NOT NULL,
  expires_at TIMESTAMPTZ NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## review_votes

```sql
CREATE TABLE review_votes (
  id UUID PRIMARY KEY,
  review_session_id UUID NOT NULL REFERENCES review_sessions(id) ON DELETE CASCADE,
  reviewer_type TEXT NOT NULL,
  selected_option TEXT,
  impression_ratings JSONB NOT NULL DEFAULT '{}'::jsonb,
  comment TEXT,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```
