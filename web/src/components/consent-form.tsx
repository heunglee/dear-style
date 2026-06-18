"use client";

import { useRouter } from "next/navigation";
import { FormEvent, useState } from "react";

import { recordConsent, type ConsentType } from "@/lib/api";

const consentVersion = "2026-01";

const requiredConsents: Array<{ type: ConsentType; label: string }> = [
  {
    type: "face_image_upload",
    label: "Use my face photo for comparison-based style tests."
  },
  {
    type: "raw_image_storage",
    label: "Store my original image so I can review, retake, or delete it later."
  }
];

const optionalConsents: Array<{ type: ConsentType; label: string }> = [
  {
    type: "friend_review_sharing",
    label: "Let me create private friend review links when I choose."
  },
  {
    type: "anonymized_analytics",
    label: "Use anonymized preference patterns to improve shade and style insights."
  }
];

export function ConsentForm() {
  const router = useRouter();
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState<string | null>(null);
  const [isSubmitting, setIsSubmitting] = useState(false);

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setError(null);
    setSuccess(null);
    setIsSubmitting(true);

    const formData = new FormData(event.currentTarget);

    try {
      const records = [...requiredConsents, ...optionalConsents].map((consent) =>
        recordConsent({
          consent_type: consent.type,
          granted: formData.get(consent.type) === "on",
          version: consentVersion
        })
      );

      await Promise.all(records);
      setSuccess("Consent saved. Color Harmony Test is next.");
      router.push("/upload");
    } catch (caught) {
      setError(caught instanceof Error ? caught.message : "Please try again.");
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="checkbox-group">
        {requiredConsents.map((consent) => (
          <label className="checkbox-label" key={consent.type}>
            <input name={consent.type} required type="checkbox" />
            <span>{consent.label}</span>
          </label>
        ))}
      </div>

      <div className="checkbox-group">
        {optionalConsents.map((consent) => (
          <label className="checkbox-label" key={consent.type}>
            <input name={consent.type} type="checkbox" />
            <span>{consent.label}</span>
          </label>
        ))}
      </div>

      {error ? <div className="status status-error">{error}</div> : null}
      {success ? <div className="status status-success">{success}</div> : null}

      <button className="button button-primary" disabled={isSubmitting} type="submit">
        {isSubmitting ? "Saving..." : "Save consent"}
      </button>
    </form>
  );
}
