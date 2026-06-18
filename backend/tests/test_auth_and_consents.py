def test_register_login_me_and_record_consent(client):
    register_response = client.post(
        "/api/v1/auth/register",
        json={
            "email": "jane@example.com",
            "password": "strong-password",
            "display_name": "Jane",
        },
    )
    assert register_response.status_code == 201
    token = register_response.json()["access_token"]

    login_response = client.post(
        "/api/v1/auth/login",
        json={"email": "jane@example.com", "password": "strong-password"},
    )
    assert login_response.status_code == 200

    headers = {"Authorization": f"Bearer {token}"}
    me_response = client.get("/api/v1/auth/me", headers=headers)
    assert me_response.status_code == 200
    assert me_response.json()["email"] == "jane@example.com"

    consent_response = client.post(
        "/api/v1/consents",
        headers=headers,
        json={
            "consent_type": "face_image_upload",
            "granted": True,
            "version": "2026-01",
        },
    )
    assert consent_response.status_code == 201
    assert consent_response.json()["granted"] is True

    consents_response = client.get("/api/v1/consents", headers=headers)
    assert consents_response.status_code == 200
    assert len(consents_response.json()) == 1

