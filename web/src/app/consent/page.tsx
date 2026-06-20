import { ConsentForm } from "@/components/consent-form";

export default function ConsentPage() {
  return (
    <main>
      <section className="consent-page">
        <div className="hero-copy">
          <span className="eyebrow">Consent</span>
          <h1>Stay in control.</h1>
          <p className="lede">
            Dear Style uses your photo only for the coaching and feedback flows you choose to run.
            Sharing stays off unless a later review flow asks for your explicit permission.
          </p>
        </div>

        <div className="panel">
          <div className="panel-body">
            <ul className="consent-list" aria-label="Privacy summary">
              <li>
                <strong>Photo use</strong>
                <p>Face photos support landmark checks, coaching guides, and feedback summaries.</p>
              </li>
              <li>
                <strong>Sharing</strong>
                <p>Private review links are deferred and will require a separate choice.</p>
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
