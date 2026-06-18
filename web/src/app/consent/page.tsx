import { ConsentForm } from "@/components/consent-form";

export default function ConsentPage() {
  return (
    <main>
      <section className="consent-page">
        <div className="hero-copy">
          <span className="eyebrow">Consent</span>
          <h1>Stay in control.</h1>
          <p className="lede">
            Dear Style uses your photo only to create comparison sessions and style reports you
            choose to run. Sharing stays off unless you create a friend review link.
          </p>
        </div>

        <div className="panel">
          <div className="panel-body">
            <ul className="consent-list" aria-label="Privacy summary">
              <li>
                <strong>Photo use</strong>
                <p>Face photos support color and style comparison sessions.</p>
              </li>
              <li>
                <strong>Sharing</strong>
                <p>Friend review links are created only after you choose that flow.</p>
              </li>
              <li>
                <strong>Deletion</strong>
                <p>Uploaded images are designed to remain deletable from your account.</p>
              </li>
            </ul>
            <ConsentForm />
          </div>
        </div>
      </section>
    </main>
  );
}
