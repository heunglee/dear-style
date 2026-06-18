package com.deardaughterbeauty.dearstyle

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
                    onSaved = { screen = AppScreen.ColorHarmony },
                )
                AppScreen.ColorHarmony -> ColorHarmonyScreen()
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
fun ColorHarmonyScreen() {
    var step by rememberSaveable { mutableStateOf(TestStep.Upload) }
    var selectedPhotoUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var currentPairIndex by rememberSaveable { mutableIntStateOf(0) }
    val votes = remember { mutableStateListOf<ColorHarmonyVote>() }
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri ->
        selectedPhotoUri = uri
        if (uri != null) {
            step = TestStep.Setup
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = step.title,
            color = DesignTokens.Charcoal,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 38.sp,
        )
        Spacer(modifier = Modifier.height(18.dp))

        when (step) {
            TestStep.Upload -> {
                Text(
                    text = "Choose one face photo to preview the A/B color comparisons.",
                    color = DesignTokens.Cocoa,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                )
                Spacer(modifier = Modifier.height(22.dp))
                Button(
                    onClick = {
                        photoPicker.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly),
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DesignTokens.Rose),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Choose photo")
                }
            }
            TestStep.Setup -> {
                PhotoSummary(selectedPhotoUri)
                Spacer(modifier = Modifier.height(14.dp))
                ColorHarmonyPair.defaults.forEach { pair ->
                    PairSummary(pair)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        votes.clear()
                        currentPairIndex = 0
                        step = TestStep.Compare
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DesignTokens.Rose),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Start")
                }
            }
            TestStep.Compare -> {
                val pair = ColorHarmonyPair.defaults[currentPairIndex]
                Text(
                    text = "${currentPairIndex + 1} / ${ColorHarmonyPair.defaults.size}",
                    color = DesignTokens.Rose,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ComparisonCard(
                        title = pair.optionA,
                        swatch = pair.colorA,
                        modifier = Modifier.weight(1f),
                        onSelect = {
                            votes.add(ColorHarmonyVote(pair.title, pair.optionA, pair.signalA))
                            advanceVote(currentPairIndex, { currentPairIndex = it }, { step = TestStep.Report })
                        },
                    )
                    ComparisonCard(
                        title = pair.optionB,
                        swatch = pair.colorB,
                        modifier = Modifier.weight(1f),
                        onSelect = {
                            votes.add(ColorHarmonyVote(pair.title, pair.optionB, pair.signalB))
                            advanceVote(currentPairIndex, { currentPairIndex = it }, { step = TestStep.Report })
                        },
                    )
                }
                OutlinedButton(
                    onClick = {
                        votes.add(ColorHarmonyVote(pair.title, "Unsure", UndertoneSignal.Unsure))
                        advanceVote(currentPairIndex, { currentPairIndex = it }, { step = TestStep.Report })
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                ) {
                    Text("Unsure")
                }
            }
            TestStep.Report -> {
                val warmVotes = votes.count { it.signal == UndertoneSignal.Warm }
                val coolVotes = votes.count { it.signal == UndertoneSignal.Cool }
                val tendency = when {
                    warmVotes > coolVotes -> "Warm-leaning harmony"
                    coolVotes > warmVotes -> "Cool-leaning harmony"
                    else -> "Balanced harmony"
                }
                Text(
                    text = tendency,
                    color = DesignTokens.Charcoal,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$warmVotes warm signals · $coolVotes cool signals",
                    color = DesignTokens.Cocoa,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.height(14.dp))
                votes.forEach { vote ->
                    ResultRow(vote)
                }
            }
        }
    }
}

@Composable
fun PhotoSummary(uri: Uri?) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text("Selected photo", color = DesignTokens.Charcoal, fontWeight = FontWeight.Bold)
            Text(
                text = uri?.lastPathSegment ?: "Ready",
                color = DesignTokens.Cocoa,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun PairSummary(pair: ColorHarmonyPair) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(pair.optionA, color = DesignTokens.Charcoal, fontWeight = FontWeight.SemiBold)
            Text(pair.optionB, color = DesignTokens.Charcoal, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ComparisonCard(title: String, swatch: Color, modifier: Modifier, onSelect: () -> Unit) {
    Card(
        onClick = onSelect,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier,
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(swatch),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(title, color = DesignTokens.Charcoal, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ResultRow(vote: ColorHarmonyVote) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(vote.pairTitle, color = DesignTokens.Cocoa)
            Text(vote.selectedLabel, color = DesignTokens.Charcoal, fontWeight = FontWeight.Bold)
        }
    }
}

private fun advanceVote(currentIndex: Int, setIndex: (Int) -> Unit, showReport: () -> Unit) {
    if (currentIndex < ColorHarmonyPair.defaults.lastIndex) {
        setIndex(currentIndex + 1)
    } else {
        showReport()
    }
}

enum class AppScreen {
    Welcome,
    Consent,
    ColorHarmony,
}

enum class TestStep(val title: String) {
    Upload("Start with a photo."),
    Setup("Color Harmony Test"),
    Compare("Which feels more harmonious?"),
    Report("Self-only report"),
}

data class ColorHarmonyPair(
    val optionA: String,
    val optionB: String,
    val colorA: Color,
    val colorB: Color,
    val signalA: UndertoneSignal,
    val signalB: UndertoneSignal,
) {
    val title: String = "$optionA / $optionB"

    companion object {
        val defaults = listOf(
            ColorHarmonyPair(
                optionA = "Gold",
                optionB = "Silver",
                colorA = Color(0xFFD4AF37),
                colorB = Color(0xFFC0C0C0),
                signalA = UndertoneSignal.Warm,
                signalB = UndertoneSignal.Cool,
            ),
            ColorHarmonyPair(
                optionA = "Ivory",
                optionB = "Pure White",
                colorA = Color(0xFFFFFFF0),
                colorB = Color.White,
                signalA = UndertoneSignal.Warm,
                signalB = UndertoneSignal.Cool,
            ),
            ColorHarmonyPair(
                optionA = "Camel",
                optionB = "Cool Grey",
                colorA = Color(0xFFC19A6B),
                colorB = Color(0xFF8C92AC),
                signalA = UndertoneSignal.Warm,
                signalB = UndertoneSignal.Cool,
            ),
        )
    }
}

data class ColorHarmonyVote(
    val pairTitle: String,
    val selectedLabel: String,
    val signal: UndertoneSignal,
)

enum class UndertoneSignal {
    Warm,
    Cool,
    Unsure,
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
