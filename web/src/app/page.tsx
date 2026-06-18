import Link from "next/link";

export default function Home() {
  return (
    <main>
      <section className="hero">
        <div className="hero-copy">
          <span className="eyebrow">Color Harmony Test</span>
          <h1>Dear Style</h1>
          <p className="lede">
            Compare gentle A/B looks and discover which color families repeatedly feel more
            harmonious, brighter, and natural on you.
          </p>
          <div className="button-row">
            <Link className="button button-primary" href="/signup">
              Start Color Harmony Test
            </Link>
            <Link className="button button-secondary" href="/consent">
              Continue
            </Link>
          </div>
        </div>

        <div className="visual-panel" aria-label="Warm and cool comparison preview">
          <div className="comparison-strip">
            <div className="swatch swatch-warm">
              A<span>Gold</span>
            </div>
            <div className="swatch swatch-cool">
              B<span>Silver</span>
            </div>
          </div>
        </div>
      </section>
    </main>
  );
}
