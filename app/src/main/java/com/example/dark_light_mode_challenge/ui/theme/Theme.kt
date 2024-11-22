package com.example.dark_light_mode_challenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


// Define Dark and Light Color Schemes
val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

// ThemeSwitcher Composable to switch themes based on the flag
@Composable
fun ThemeSwitcher(isDarkMode: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme,
        typography = Typography, // Default typography
        content = content
    )
}

// DarkLightModeChallengeTheme Composable to set the theme
@Composable
fun DarkLightModeChallengeTheme(content: @Composable () -> Unit) {
    val isDarkMode = isSystemInDarkTheme()  // You can use ViewModel to manage the theme state here
    ThemeSwitcher(isDarkMode = isDarkMode, content = content)
}

