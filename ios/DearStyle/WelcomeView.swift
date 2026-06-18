import SwiftUI

struct WelcomeView: View {
    @State private var showsConsent = false

    var body: some View {
        NavigationStack {
            ZStack {
                DesignTokens.cream.ignoresSafeArea()

                VStack(alignment: .leading, spacing: 20) {
                    Spacer()

                    Text("Dear Style")
                        .font(.system(size: 56, weight: .black))
                        .foregroundStyle(DesignTokens.charcoal)
                        .lineLimit(2)
                        .minimumScaleFactor(0.8)

                    Text("Compare gentle A/B looks and discover which color families repeatedly feel more harmonious on you.")
                        .font(.system(size: 17))
                        .lineSpacing(5)
                        .foregroundStyle(DesignTokens.cocoa)

                    Button {
                        showsConsent = true
                    } label: {
                        Text("Start Color Harmony Test")
                            .frame(maxWidth: .infinity)
                    }
                    .buttonStyle(PrimaryButtonStyle())
                    .padding(.top, 8)

                    Spacer()
                }
                .padding(24)
            }
            .navigationDestination(isPresented: $showsConsent) {
                ConsentView()
            }
        }
    }
}
