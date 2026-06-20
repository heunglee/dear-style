# Dear Style Backend

FastAPI backend for the Dear Style MVP.

## Local Setup

This backend targets Python 3.14.6 or the latest Python 3.14 bugfix release.

```bash
cd backend
python3.14 -m venv .venv
source .venv/bin/activate
python -m pip install --upgrade pip
pip install -e ".[dev]"
cp .env.example .env
```

If you use `pyenv`:

```bash
pyenv install 3.14.6
pyenv local 3.14.6
python -m venv .venv
```

Run migrations after PostgreSQL is available:

```bash
cd ..
make dev-up
cd backend
alembic upgrade head
```

Start the API:

```bash
uvicorn app.main:app --reload
```

Run tests:

```bash
pytest
```

## Implemented Phase 01 Surface

- `POST /api/v1/auth/register`
- `POST /api/v1/auth/login`
- `GET /api/v1/auth/me`
- `POST /api/v1/auth/logout`
- `GET /api/v1/consents`
- `POST /api/v1/consents`
- `GET /health`

## Shared API Types

Mirror [../shared/api/type_conventions.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/shared/api/type_conventions.md) when adding or changing request and response schemas.

## Version Baseline

See [../docs/architecture/technology_stack.md](/Users/giyuk/Workspace/deardaughterbeauty.com/dear-style/docs/architecture/technology_stack.md) for the current stable backend versions.
