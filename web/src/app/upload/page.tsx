import Link from "next/link";

export default function UploadPlaceholderPage() {
  return (
    <main className="app-shell narrow-page">
      <section className="auth-layout panel">
        <div className="panel-body">
          <Link className="brand" href="/">
            <strong>Dear Style</strong>
            <span>Dear Daughter Beauty</span>
          </Link>
          <div>
            <span className="eyebrow">Next phase</span>
            <h2>Upload starts in Phase 02.</h2>
          </div>
          <p>
            Consent is now recorded. The next milestone adds face photo upload and the first A/B
            Color Harmony comparisons.
          </p>
          <Link className="button button-primary" href="/">
            Back home
          </Link>
        </div>
      </section>
    </main>
  );
}
