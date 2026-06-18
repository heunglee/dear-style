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
            var consentVisible by rememberSaveable { mutableStateOf(false) }

            if (consentVisible) {
                ConsentScreen(onBack = { consentVisible = false })
            } else {
                WelcomeScreen(onStart = { consentVisible = true })
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
            text = "Compare gentle A/B looks and discover which color families repeatedly feel more harmonious on you.",
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
            Text("Start Color Harmony Test")
        }
    }
}

@Composable
fun ConsentScreen(onBack: () -> Unit) {
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
            text = "Dear Style uses your photo for comparison sessions you choose to run. Sharing stays off unless you create a friend review link.",
            color = DesignTokens.Cocoa,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        )
        Spacer(modifier = Modifier.height(22.dp))
        ConsentOption(
            label = "Use my face photo for comparison-based style tests.",
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
            onClick = onBack,
            enabled = faceConsent && storageConsent,
            colors = ButtonDefaults.buttonColors(containerColor = DesignTokens.Rose),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Save consent")
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

object DesignTokens {
    val Cream = Color(0xFFFFF8F1)
    val Blush = Color(0xFFF6D5D8)
    val Rose = Color(0xFFC96F7C)
    val Cocoa = Color(0xFF5B3F3A)
    val Charcoal = Color(0xFF2E2A2A)
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    DearStyleApp()
}
