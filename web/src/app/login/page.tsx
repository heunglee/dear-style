import Link from "next/link";

import { AuthForm } from "@/components/auth-form";

export default function LoginPage() {
  return (
    <main className="app-shell narrow-page">
      <section className="auth-layout panel">
        <div className="panel-body">
          <Link className="brand" href="/">
            <strong>Dear Style</strong>
            <span>Dear Daughter Beauty</span>
          </Link>
          <div>
            <span className="eyebrow">Welcome back</span>
            <h2>Continue your style test.</h2>
          </div>
          <AuthForm mode="login" />
        </div>
      </section>
    </main>
  );
}
