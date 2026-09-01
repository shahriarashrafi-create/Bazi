package com.herolife.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.herolife.core.model.GameWallet
import com.herolife.core.model.PlayerProgress

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

    val player = PlayerProgress(
        level = 1,
        xp = 0,
        xpToNextLevel = 100
    )

    val wallet = GameWallet(
        gold = 0,
        diamonds = 0
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),

            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            Text(
                text = "HeroLife",
                fontSize = 32.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "قهرمان زندگی خودت باش",
                fontSize = 18.sp,
                color = Color(0xFF9DB2C8)
            )

            Text(
                text = "سطح ${player.level}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "XP: ${player.xp} / ${player.xpToNextLevel}"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "🪙 ${wallet.gold} طلا",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "💎 ${wallet.diamonds} الماس",
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),

                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    text = "⚔ شروع بازی",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Module 01 / 20 — Project Core",
                color = Color(0xFF8094AA),
                fontSize = 13.sp
            )
        }
    }
}
