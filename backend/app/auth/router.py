from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session

from app.auth.dependencies import get_current_user
from app.auth.schemas import AuthResponse, LoginRequest, RegisterRequest
from app.core.database import get_db
from app.core.errors import ApiError
from app.core.security import create_access_token
from app.users.models import User
from app.users.schemas import UserRead
from app.users.service import authenticate_user, create_user, get_user_by_email

router = APIRouter()


@router.post("/register", response_model=AuthResponse, status_code=201)
def register(payload: RegisterRequest, db: Session = Depends(get_db)) -> AuthResponse:
    if get_user_by_email(db, payload.email):
        raise ApiError(409, "EMAIL_ALREADY_REGISTERED", "An account already exists for this email.")

    user = create_user(
        db,
        email=payload.email,
        password=payload.password,
        display_name=payload.display_name,
    )
    return AuthResponse(access_token=create_access_token(user.id), user=user)


@router.post("/login", response_model=AuthResponse)
def login(payload: LoginRequest, db: Session = Depends(get_db)) -> AuthResponse:
    user = authenticate_user(db, payload.email, payload.password)
    if user is None:
        raise ApiError(401, "INVALID_CREDENTIALS", "Email or password is incorrect.")

    return AuthResponse(access_token=create_access_token(user.id), user=user)


@router.get("/me", response_model=UserRead)
def me(current_user: User = Depends(get_current_user)) -> User:
    return current_user


@router.post("/logout")
def logout() -> dict[str, str]:
    return {"status": "ok"}

