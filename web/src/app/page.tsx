import Link from "next/link";

export default function Home() {
  return (
    <main className="app-shell">
      <div className="page">
        <header className="topbar">
          <Link className="brand" href="/">
            <strong>Dear Style</strong>
            <span>Dear Daughter Beauty</span>
          </Link>
          <nav className="nav-actions" aria-label="Account">
            <Link className="button button-ghost" href="/login">
              Log in
            </Link>
            <Link className="button button-secondary" href="/signup">
              Sign up
            </Link>
          </nav>
        </header>

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
      </div>
    </main>
  );
}
