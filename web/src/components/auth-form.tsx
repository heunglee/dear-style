"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import { FormEvent, useState } from "react";

import { login, register } from "@/lib/api";
import { setAccessToken } from "@/lib/auth-storage";

type AuthMode = "login" | "signup";

type AuthFormProps = {
  mode: AuthMode;
};

export function AuthForm({ mode }: AuthFormProps) {
  const router = useRouter();
  const [error, setError] = useState<string | null>(null);
  const [isSubmitting, setIsSubmitting] = useState(false);

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setError(null);
    setIsSubmitting(true);

    const formData = new FormData(event.currentTarget);
    const email = String(formData.get("email") ?? "");
    const password = String(formData.get("password") ?? "");
    const displayName = String(formData.get("display_name") ?? "").trim();

    try {
      const response =
        mode === "signup"
          ? await register({
              email,
              password,
              display_name: displayName || undefined
            })
          : await login({ email, password });

      setAccessToken(response.access_token);
      router.push("/consent");
    } catch (caught) {
      setError(caught instanceof Error ? caught.message : "Please try again.");
    } finally {
      setIsSubmitting(false);
    }
  }

  const isSignup = mode === "signup";

  return (
    <form className="form" onSubmit={handleSubmit}>
      {isSignup ? (
        <div className="field">
          <label htmlFor="display_name">Name</label>
          <input id="display_name" name="display_name" autoComplete="name" />
        </div>
      ) : null}

      <div className="field">
        <label htmlFor="email">Email</label>
        <input id="email" name="email" type="email" autoComplete="email" required />
      </div>

      <div className="field">
        <label htmlFor="password">Password</label>
        <input
          id="password"
          name="password"
          type="password"
          autoComplete={isSignup ? "new-password" : "current-password"}
          minLength={isSignup ? 8 : 1}
          required
        />
      </div>

      {error ? <div className="status status-error">{error}</div> : null}

      <button className="button button-primary" disabled={isSubmitting} type="submit">
        {isSubmitting ? "Working..." : isSignup ? "Create account" : "Log in"}
      </button>

      <p className="form-footer">
        {isSignup ? "Already have an account? " : "New to Dear Style? "}
        <Link href={isSignup ? "/login" : "/signup"}>{isSignup ? "Log in" : "Sign up"}</Link>
      </p>
    </form>
  );
}
