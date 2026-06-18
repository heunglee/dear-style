import Link from "next/link";

import { AuthForm } from "@/components/auth-form";

export default function SignupPage() {
  return (
    <main className="app-shell narrow-page">
      <section className="auth-layout panel">
        <div className="panel-body">
          <Link className="brand" href="/">
            <strong>Dear Style</strong>
            <span>Dear Daughter Beauty</span>
          </Link>
          <div>
            <span className="eyebrow">Create account</span>
            <h2>Start with your own comparisons.</h2>
          </div>
          <AuthForm mode="signup" />
        </div>
      </section>
    </main>
  );
}
