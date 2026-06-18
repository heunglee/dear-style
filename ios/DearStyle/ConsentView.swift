import SwiftUI

struct ConsentView: View {
    @State private var faceImageConsent = false
    @State private var rawImageStorageConsent = false
    @State private var friendReviewConsent = false
    @State private var anonymizedAnalyticsConsent = false
    @State private var saved = false

    var body: some View {
        ZStack {
            DesignTokens.cream.ignoresSafeArea()

            ScrollView {
                VStack(alignment: .leading, spacing: 18) {
                    Text("Stay in control.")
                        .font(.system(size: 38, weight: .bold))
                        .foregroundStyle(DesignTokens.charcoal)

                    Text("Dear Style uses your photo for comparison sessions you choose to run. Sharing stays off unless you create a friend review link.")
                        .font(.system(size: 16))
                        .lineSpacing(5)
                        .foregroundStyle(DesignTokens.cocoa)

                    VStack(spacing: 12) {
                        ConsentToggle(
                            label: "Use my face photo for comparison-based style tests.",
                            isOn: $faceImageConsent
                        )
                        ConsentToggle(
                            label: "Store my original image so I can review, retake, or delete it later.",
                            isOn: $rawImageStorageConsent
                        )
                        ConsentToggle(
                            label: "Let me create private friend review links when I choose.",
                            isOn: $friendReviewConsent
                        )
                        ConsentToggle(
                            label: "Use anonymized preference patterns to improve shade and style insights.",
                            isOn: $anonymizedAnalyticsConsent
                        )
                    }
                    .padding(.top, 8)

                    if saved {
                        Text("Consent saved. Upload begins in Phase 02.")
                            .font(.callout.weight(.semibold))
                            .foregroundStyle(DesignTokens.success)
                    }

                    Button {
                        saved = true
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
