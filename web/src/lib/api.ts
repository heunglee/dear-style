import { z } from "zod";

import { getAccessToken } from "@/lib/auth-storage";

const apiBaseUrl = process.env.NEXT_PUBLIC_API_BASE_URL ?? "http://localhost:8000/api/v1";

const userSchema = z.object({
  id: z.string(),
  email: z.string().email(),
  display_name: z.string().nullable(),
  created_at: z.string()
});

const authResponseSchema = z.object({
  access_token: z.string(),
  token_type: z.string(),
  user: userSchema
});

const consentSchema = z.object({
  id: z.string(),
  user_id: z.string(),
  consent_type: z.enum([
    "face_image_upload",
    "raw_image_storage",
    "friend_review_sharing",
    "anonymized_analytics"
  ]),
  granted: z.boolean(),
  version: z.string(),
  created_at: z.string()
});

export type User = z.infer<typeof userSchema>;
export type AuthResponse = z.infer<typeof authResponseSchema>;
export type Consent = z.infer<typeof consentSchema>;
export type ConsentType = Consent["consent_type"];

type ApiRequestOptions = {
  token?: string | null;
} & RequestInit;

async function apiRequest(path: string, options: ApiRequestOptions = {}) {
  const headers = new Headers(options.headers);

  if (!headers.has("Content-Type") && options.body) {
    headers.set("Content-Type", "application/json");
  }

  const token = options.token ?? getAccessToken();
  if (token) {
    headers.set("Authorization", `Bearer ${token}`);
  }

  const response = await fetch(`${apiBaseUrl}${path}`, {
    ...options,
    headers
  });

  const payload = await response.json().catch(() => null);

  if (!response.ok) {
    const detail = Array.isArray(payload?.detail)
      ? payload.detail.map((item: { msg?: string }) => item.msg).filter(Boolean).join(" ")
      : payload?.detail;
    const message =
      payload?.error?.message ??
      detail ??
      "We could not complete that request. Please try again.";
    throw new Error(message);
  }

  return payload;
}

export async function register(input: {
  email: string;
  password: string;
  display_name?: string;
}) {
  const payload = await apiRequest("/auth/register", {
    method: "POST",
    body: JSON.stringify(input)
  });

  return authResponseSchema.parse(payload);
}

export async function login(input: { email: string; password: string }) {
  const payload = await apiRequest("/auth/login", {
    method: "POST",
    body: JSON.stringify(input)
  });

  return authResponseSchema.parse(payload);
}

export async function getMe() {
  const payload = await apiRequest("/auth/me");

  return userSchema.parse(payload);
}

export async function listConsents() {
  const payload = await apiRequest("/consents");

  return z.array(consentSchema).parse(payload);
}

export async function recordConsent(input: {
  consent_type: ConsentType;
  granted: boolean;
  version: string;
}) {
  const payload = await apiRequest("/consents", {
    method: "POST",
    body: JSON.stringify(input)
  });

  return consentSchema.parse(payload);
}
