package com.example.bmicalculator.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1c51ed), // Electric Blue
    secondary = Color(0xFF008080), // Deep Teal
    tertiary = Color(0xFF8A2BE2), // Neon Purple
    background = Color(0xFF102341 ), // Midnight Blue
    surface = Color(0xFF002D67), // Dark Steel Blue
    onPrimary = Color(0xFFFFFFFF), // Pure White
    onSecondary = Color(0xFFA7E0E4), // Light Cyan
    onTertiary = Color(0xFFD1B3FF), // Soft Lavender
    onBackground = Color(0xFFF8F9FA), // Soft Light Gray
    onSurface = Color(0xFFF8F9FA) // Light Grayish White
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),

)

@Composable
fun BmiCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
)
{
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}