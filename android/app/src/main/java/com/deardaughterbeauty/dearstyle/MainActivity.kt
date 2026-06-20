package com.deardaughterbeauty.dearstyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DearStyleApp()
        }
    }
}

@Composable
fun DearStyleApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(DesignTokens.Cream),
            color = DesignTokens.Cream,
        ) {
            var screen by rememberSaveable { mutableStateOf(AppScreen.Welcome) }

            when (screen) {
                AppScreen.Welcome -> WelcomeScreen(onStart = { screen = AppScreen.Consent })
                AppScreen.Consent -> ConsentScreen(
                    onBack = { screen = AppScreen.Welcome },
                    onSaved = { screen = AppScreen.Coach },
                )
                AppScreen.Coach -> CoachScreen(onBack = { screen = AppScreen.Consent })
            }
        }
    }
}

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Dear Style",
            color = DesignTokens.Charcoal,
            fontSize = 52.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 52.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "A makeup coach for lip line, brows, blush, and before/after feedback.",
            color = DesignTokens.Cocoa,
            fontSize = 17.sp,
            lineHeight = 26.sp,
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = onStart,
            colors = ButtonDefaults.buttonColors(containerColor = DesignTokens.Rose),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Start Makeup Coach")
        }
    }
}

@Composable
fun ConsentScreen(onBack: () -> Unit, onSaved: () -> Unit) {
    var faceConsent by rememberSaveable { mutableStateOf(false) }
    var storageConsent by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Stay in control.",
            color = DesignTokens.Charcoal,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Use your photo only for the coaching and feedback you choose.",
            color = DesignTokens.Cocoa,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        )
        Spacer(modifier = Modifier.height(22.dp))
        ConsentOption(
            label = "Use my face photo for makeup coaching and feedback.",
            checked = faceConsent,
            onCheckedChange = { faceConsent = it },
        )
        ConsentOption(
            label = "Store my original image so I can review, retake, or delete it later.",
            checked = storageConsent,
            onCheckedChange = { storageConsent = it },
        )
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            onClick = onSaved,
            enabled = faceConsent && storageConsent,
            colors = ButtonDefaults.buttonColors(containerColor = DesignTokens.Rose),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Save consent")
        }
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        ) {
            Text("Back")
        }
    }
}

@Composable
fun ConsentOption(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .toggleable(
                value = checked,
                role = Role.Checkbox,
                onValueChange = onCheckedChange,
            ),
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Checkbox(checked = checked, onCheckedChange = null)
            Text(text = label, color = DesignTokens.Charcoal, lineHeight = 22.sp)
        }
    }
}

@Composable
fun CoachScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Choose a coaching target.",
            color = DesignTokens.Charcoal,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 38.sp,
        )
        Spacer(modifier = Modifier.height(18.dp))
        coachingTargets.forEach { target ->
            CoachingTargetCard(target)
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Back")
        }
    }
}

@Composable
fun CoachingTargetCard(target: CoachingTarget) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = target.name,
                color = DesignTokens.Charcoal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = target.detail,
                color = DesignTokens.Cocoa,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            )
        }
    }
}

enum class AppScreen {
    Welcome,
    Consent,
    Coach,
}

data class CoachingTarget(
    val name: String,
    val detail: String,
)

val coachingTargets = listOf(
    CoachingTarget("Lip line", "Outline, overline, and asymmetry correction"),
    CoachingTarget("Eyebrows", "Start point, arch point, tail point, and fill guidance"),
    CoachingTarget("Blush", "Placement map, application direction, and blending zone"),
    CoachingTarget("Feedback", "Before/after observations and improvement notes"),
)

object DesignTokens {
    val Cream = Color(0xFFFFF8F1)
    val Rose = Color(0xFFC96F7C)
    val Cocoa = Color(0xFF5B3F3A)
    val Charcoal = Color(0xFF2E2A2A)
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    DearStyleApp()
}
