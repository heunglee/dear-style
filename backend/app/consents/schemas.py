from datetime import datetime
from enum import StrEnum
from uuid import UUID

from pydantic import BaseModel, ConfigDict, Field


class ConsentType(StrEnum):
    face_image_upload = "face_image_upload"
    raw_image_storage = "raw_image_storage"
    friend_review_sharing = "friend_review_sharing"
    anonymized_analytics = "anonymized_analytics"


class ConsentCreate(BaseModel):
    consent_type: ConsentType
    granted: bool
    version: str = Field(min_length=1, max_length=40)


class ConsentRead(BaseModel):
    model_config = ConfigDict(from_attributes=True)

    id: UUID
    user_id: UUID
    consent_type: ConsentType
    granted: bool
    version: str
    created_at: datetime

