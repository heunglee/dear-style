import SwiftUI

enum DesignTokens {
    static let cream = Color(red: 1.0, green: 0.973, blue: 0.945)
    static let blush = Color(red: 0.965, green: 0.835, blue: 0.847)
    static let rose = Color(red: 0.788, green: 0.435, blue: 0.486)
    static let cocoa = Color(red: 0.357, green: 0.247, blue: 0.227)
    static let charcoal = Color(red: 0.18, green: 0.165, blue: 0.165)
    static let border = Color(red: 0.914, green: 0.863, blue: 0.843)
    static let success = Color(red: 0.31, green: 0.541, blue: 0.404)
}

struct PrimaryButtonStyle: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .font(.system(size: 16, weight: .bold))
            .foregroundStyle(.white)
            .padding(.vertical, 14)
            .background(DesignTokens.rose.opacity(configuration.isPressed ? 0.78 : 1))
            .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}
