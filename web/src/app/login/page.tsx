import { AuthForm } from "@/components/auth-form";

export default function LoginPage() {
  return (
    <main className="narrow-page">
      <section className="auth-layout panel">
        <div className="panel-body">
          <div>
            <span className="eyebrow">Welcome back</span>
            <h2>Continue your coaching flow.</h2>
          </div>
          <AuthForm mode="login" />
        </div>
      </section>
    </main>
  );
}
