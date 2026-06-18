from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session

from app.auth.dependencies import get_current_user
from app.consents.schemas import ConsentCreate, ConsentRead
from app.consents.service import create_consent, list_consents
from app.core.database import get_db
from app.users.models import User

router = APIRouter()


@router.get("", response_model=list[ConsentRead])
def get_consents(
    current_user: User = Depends(get_current_user),
    db: Session = Depends(get_db),
) -> list[ConsentRead]:
    return list_consents(db, current_user.id)


@router.post("", response_model=ConsentRead, status_code=201)
def post_consent(
    payload: ConsentCreate,
    current_user: User = Depends(get_current_user),
    db: Session = Depends(get_db),
) -> ConsentRead:
    return create_consent(
        db,
        user_id=current_user.id,
        consent_type=payload.consent_type,
        granted=payload.granted,
        version=payload.version,
    )

