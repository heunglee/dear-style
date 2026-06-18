from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from app.auth.router import router as auth_router
from app.consents.router import router as consents_router
from app.core.config import settings
from app.core.errors import register_error_handlers

app = FastAPI(
    title="Dear Style API",
    version="0.1.0",
    openapi_url=f"{settings.api_v1_prefix}/openapi.json",
)

register_error_handlers(app)

app.add_middleware(
    CORSMiddleware,
    allow_origins=settings.allowed_cors_origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

app.include_router(auth_router, prefix=f"{settings.api_v1_prefix}/auth", tags=["auth"])
app.include_router(consents_router, prefix=f"{settings.api_v1_prefix}/consents", tags=["consents"])


@app.get("/health", tags=["health"])
def health_check() -> dict[str, str]:
    return {"status": "ok"}
