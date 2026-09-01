package com.herolife.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HeroLifeTheme {
                CompositionLocalProvider(
                    LocalLayoutDirection provides LayoutDirection.Rtl
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HeroLifeTheme(
    content: @Composable () -> Unit
) {
    val colors = darkColorScheme(
        primary = Color(0xFFD8AF56),
        secondary = Color(0xFF56C7FF),
        background = Color(0xFF07111F),
        surface = Color(0xFF0E1A2B),
        onPrimary = Color.Black,
        onBackground = Color.White,
        onSurface = Color.White
    )

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "HeroLife",
                fontSize = 32.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "قهرمان زندگی خودت باش",
                fontSize = 18.sp
            )

            Text(
                text = "ماژول 01 / 20 — Project Core"
            )
        }
    }
}
