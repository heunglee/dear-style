import SwiftUI

struct CoachView: View {
    private let targets = [
        CoachingTarget(name: "Lip line", detail: "Outline, overline, and asymmetry correction"),
        CoachingTarget(name: "Eyebrows", detail: "Start point, arch point, tail point, and fill guidance"),
        CoachingTarget(name: "Blush", detail: "Placement map, application direction, and blending zone"),
        CoachingTarget(name: "Feedback", detail: "Before/after observations and improvement notes")
    ]

    var body: some View {
        ZStack {
            DesignTokens.cream.ignoresSafeArea()

            ScrollView {
                VStack(alignment: .leading, spacing: 18) {
                    Text("Choose a coaching target.")
                        .font(.system(size: 38, weight: .bold))
                        .foregroundStyle(DesignTokens.charcoal)
                        .fixedSize(horizontal: false, vertical: true)

                    Text("Start with the area you want to refine, then move through capture, guidance, and feedback.")
                        .font(.system(size: 16))
                        .lineSpacing(5)
                        .foregroundStyle(DesignTokens.cocoa)

                    VStack(spacing: 12) {
                        ForEach(targets) { target in
                            CoachingTargetCard(target: target)
                        }
                    }
                    .padding(.top, 8)
                }
                .padding(24)
            }
        }
        .navigationTitle("Coach")
        .navigationBarTitleDisplayMode(.inline)
    }
}

private struct CoachingTargetCard: View {
    let target: CoachingTarget

    var body: some View {
        VStack(alignment: .leading, spacing: 6) {
            Text(target.name)
                .font(.system(size: 18, weight: .bold))
                .foregroundStyle(DesignTokens.charcoal)

            Text(target.detail)
                .font(.system(size: 14))
                .lineSpacing(3)
                .foregroundStyle(DesignTokens.cocoa)
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(16)
        .background(.white, in: RoundedRectangle(cornerRadius: 8))
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(DesignTokens.border)
        )
    }
}

private struct CoachingTarget: Identifiable {
    let id = UUID()
    let name: String
    let detail: String
}
