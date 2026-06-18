from uuid import UUID

from sqlalchemy import select
from sqlalchemy.orm import Session

from app.consents.models import UserConsent


def list_consents(db: Session, user_id: UUID) -> list[UserConsent]:
    return list(
        db.scalars(
            select(UserConsent)
            .where(UserConsent.user_id == user_id)
            .order_by(UserConsent.created_at.desc())
        )
    )


def create_consent(
    db: Session,
    user_id: UUID,
    consent_type: str,
    granted: bool,
    version: str,
) -> UserConsent:
    consent = UserConsent(
        user_id=user_id,
        consent_type=consent_type,
        granted=granted,
        version=version,
    )
    db.add(consent)
    db.commit()
    db.refresh(consent)
    return consent

