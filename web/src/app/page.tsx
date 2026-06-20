import Link from "next/link";

export default function Home() {
  return (
    <main>
      <section className="hero">
        <div className="hero-copy">
          <span className="eyebrow">AI Makeup Coach</span>
          <h1>Dear Style</h1>
          <p className="lede">
            Get face-geometry-based guidance for lip line, eyebrow shaping, blush placement, and
            before/after makeup feedback.
          </p>
          <div className="button-row">
            <Link className="button button-primary" href="/signup">
              Start Makeup Coach
            </Link>
            <Link className="button button-secondary" href="/consent">
              Continue
            </Link>
          </div>
        </div>

        <div className="visual-panel coaching-visual" aria-label="Makeup coaching preview">
          <div className="face-guide face-guide-lips" />
          <div className="face-guide face-guide-brow face-guide-brow-left" />
          <div className="face-guide face-guide-brow face-guide-brow-right" />
          <div className="coach-target-strip">
            <div>
              <strong>Lip line</strong>
              <span>Outline and balance</span>
            </div>
            <div>
              <strong>Eyebrows</strong>
              <span>Start, arch, tail</span>
            </div>
            <div>
              <strong>Blush</strong>
              <span>Place and blend</span>
            </div>
          </div>
        </div>
      </section>
    </main>
  );
}
