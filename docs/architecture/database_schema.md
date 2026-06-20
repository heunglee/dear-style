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

## images

```sql
CREATE TABLE images (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  purpose TEXT NOT NULL,
  storage_key TEXT NOT NULL,
  media_type TEXT NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## face_analyses

```sql
CREATE TABLE face_analyses (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  source_image_id UUID NOT NULL REFERENCES images(id),
  status TEXT NOT NULL DEFAULT 'pending',
  facial_regions JSONB NOT NULL DEFAULT '{}'::jsonb,
  landmarks JSONB NOT NULL DEFAULT '{}'::jsonb,
  geometry_measurements JSONB NOT NULL DEFAULT '{}'::jsonb,
  confidence_score NUMERIC,
  warnings JSONB NOT NULL DEFAULT '[]'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  completed_at TIMESTAMPTZ
);
```

## coaching_sessions

```sql
CREATE TABLE coaching_sessions (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  face_analysis_id UUID REFERENCES face_analyses(id),
  target_area TEXT NOT NULL,
  goal TEXT,
  status TEXT NOT NULL DEFAULT 'started',
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## coaching_guides

```sql
CREATE TABLE coaching_guides (
  id UUID PRIMARY KEY,
  coaching_session_id UUID NOT NULL REFERENCES coaching_sessions(id) ON DELETE CASCADE,
  guide_type TEXT NOT NULL,
  instructions JSONB NOT NULL DEFAULT '[]'::jsonb,
  overlay_primitives JSONB NOT NULL DEFAULT '[]'::jsonb,
  correction_feedback JSONB NOT NULL DEFAULT '[]'::jsonb,
  confidence_score NUMERIC,
  warnings JSONB NOT NULL DEFAULT '[]'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## feedback_results

```sql
CREATE TABLE feedback_results (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  before_image_id UUID REFERENCES images(id),
  after_image_id UUID NOT NULL REFERENCES images(id),
  target_area TEXT NOT NULL,
  observations JSONB NOT NULL DEFAULT '[]'::jsonb,
  improvement_suggestions JSONB NOT NULL DEFAULT '[]'::jsonb,
  confidence_score NUMERIC,
  warnings JSONB NOT NULL DEFAULT '[]'::jsonb,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## recommendations

```sql
CREATE TABLE recommendations (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  face_analysis_id UUID REFERENCES face_analyses(id),
  occasion TEXT,
  style_goal TEXT,
  strategy JSONB NOT NULL DEFAULT '{}'::jsonb,
  product_categories JSONB NOT NULL DEFAULT '[]'::jsonb,
  confidence_score NUMERIC,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
```

## Deferred Tables

Lesson catalogs, trace practice sessions, friend reviews, and product catalogs are deferred until the coaching MVP is validated.
