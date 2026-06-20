import { AuthForm } from "@/components/auth-form";

export default function SignupPage() {
  return (
    <main className="narrow-page">
      <section className="auth-layout panel">
        <div className="panel-body">
          <div>
            <span className="eyebrow">Create account</span>
            <h2>Start with your own makeup coach.</h2>
          </div>
          <AuthForm mode="signup" />
        </div>
      </section>
    </main>
  );
}
