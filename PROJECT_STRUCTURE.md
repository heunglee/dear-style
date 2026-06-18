# Recommended Project Structure

```text
dear-style/
  backend/
    app/
      main.py
      core/
      auth/
      users/
      consents/
      images/
      comparisons/
      reviews/
      reports/
      products/
      recommendations/
      ai/
    tests/
    alembic/
    pyproject.toml
    Dockerfile
  web/
    app/
    components/
    lib/
    styles/
    public/
    package.json
  android/
    app/
      src/main/
    build.gradle
  ios/
    DearStyle/
    DearStyleTests/
  docs/
  tasks/
  docker-compose.yml
  README.md
  CLAUDE.md
  AGENTS.md
```

## Development Order

1. Backend schema and API contracts
2. Web MVP
3. Friend review flow
4. Report generation
5. Android parity
6. iOS parity
7. AI-assisted enhancements
8. Product matching
