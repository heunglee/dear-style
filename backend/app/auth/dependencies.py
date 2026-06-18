from fastapi import Depends
from fastapi.security import OAuth2PasswordBearer
from sqlalchemy.orm import Session

from app.core.config import settings
from app.core.database import get_db
from app.core.errors import ApiError
from app.core.security import decode_access_token
from app.users.models import User
from app.users.service import get_user_by_id

oauth2_scheme = OAuth2PasswordBearer(tokenUrl=f"{settings.api_v1_prefix}/auth/login")


def get_current_user(token: str = Depends(oauth2_scheme), db: Session = Depends(get_db)) -> User:
    user_id = decode_access_token(token)
    if user_id is None:
        raise ApiError(401, "UNAUTHORIZED", "Authentication is required.")

    user = get_user_by_id(db, user_id)
    if user is None:
        raise ApiError(401, "UNAUTHORIZED", "Authentication is required.")
    return user

