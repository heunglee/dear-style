const coachingTargets = [
  {
    name: "Lip line",
    detail: "Outline, overline, and asymmetry correction",
    status: "Next"
  },
  {
    name: "Eyebrows",
    detail: "Start point, arch point, tail point, and fill guidance",
    status: "Next"
  },
  {
    name: "Blush",
    detail: "Placement map, application direction, and blending zone",
    status: "Next"
  },
  {
    name: "Feedback",
    detail: "Before/after observations, improvement notes, and confidence warnings",
    status: "Next"
  }
];

export default function CoachPage() {
  return (
    <main>
      <section className="coach-page">
        <div className="hero-copy">
          <span className="eyebrow">Coach</span>
          <h1>Choose a coaching target.</h1>
          <p className="lede">
            Start with the area you want to refine, then move through capture, guidance, and
            feedback.
          </p>
        </div>

        <div className="coach-target-grid" aria-label="Coaching targets">
          {coachingTargets.map((target) => (
            <article className="coach-target-card" key={target.name}>
              <div>
                <strong>{target.name}</strong>
                <p>{target.detail}</p>
              </div>
              <span>{target.status}</span>
            </article>
          ))}
        </div>
      </section>
    </main>
  );
}
