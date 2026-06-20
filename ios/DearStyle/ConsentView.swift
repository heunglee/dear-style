import SwiftUI

struct ConsentView: View {
    @State private var faceImageConsent = false
    @State private var rawImageStorageConsent = false
    @State private var friendReviewConsent = false
    @State private var anonymizedAnalyticsConsent = false
    @State private var saved = false
    @State private var showsCoach = false

    var body: some View {
        ZStack {
            DesignTokens.cream.ignoresSafeArea()

            ScrollView {
                VStack(alignment: .leading, spacing: 18) {
                    Text("Stay in control.")
                        .font(.system(size: 38, weight: .bold))
                        .foregroundStyle(DesignTokens.charcoal)

                    Text("Dear Style uses your photo only for the coaching and feedback you choose to run.")
                        .font(.system(size: 16))
                        .lineSpacing(5)
                        .foregroundStyle(DesignTokens.cocoa)

                    VStack(spacing: 12) {
                        ConsentToggle(
                            label: "Use my face photo for makeup coaching and feedback.",
                            isOn: $faceImageConsent
                        )
                        ConsentToggle(
                            label: "Store my original image so I can review, retake, or delete it later.",
                            isOn: $rawImageStorageConsent
                        )
                        ConsentToggle(
                            label: "Let me create private review links later if that feature is enabled.",
                            isOn: $friendReviewConsent
                        )
                        ConsentToggle(
                            label: "Use anonymized coaching patterns to improve guidance quality.",
                            isOn: $anonymizedAnalyticsConsent
                        )
                    }
                    .padding(.top, 8)

                    if saved {
                        Text("Consent saved. Makeup Coach is next.")
                            .font(.callout.weight(.semibold))
                            .foregroundStyle(DesignTokens.success)
                    }

                    Button {
                        saved = true
                        showsCoach = true
                    } label: {
                        Text("Save consent")
                            .frame(maxWidth: .infinity)
                    }
                    .buttonStyle(PrimaryButtonStyle())
                    .disabled(!faceImageConsent || !rawImageStorageConsent)
                    .padding(.top, 4)
                }
                .padding(24)
            }
        }
        .navigationTitle("Consent")
        .navigationBarTitleDisplayMode(.inline)
        .navigationDestination(isPresented: $showsCoach) {
            CoachView()
        }
    }
}

private struct ConsentToggle: View {
    let label: String
    @Binding var isOn: Bool

    var body: some View {
        Toggle(isOn: $isOn) {
            Text(label)
                .font(.system(size: 15, weight: .semibold))
                .foregroundStyle(DesignTokens.charcoal)
                .fixedSize(horizontal: false, vertical: true)
        }
        .toggleStyle(.switch)
        .padding(16)
        .background(.white, in: RoundedRectangle(cornerRadius: 8))
        .overlay(
            RoundedRectangle(cornerRadius: 8)
                .stroke(DesignTokens.border)
        )
    }
}
