# Dear Style Backend

FastAPI backend for the Dear Style MVP.

## Local Setup

This backend targets Python 3.14+.

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
