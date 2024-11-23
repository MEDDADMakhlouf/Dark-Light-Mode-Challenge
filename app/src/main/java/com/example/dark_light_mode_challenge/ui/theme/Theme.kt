package com.example.dark_light_mode_challenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


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
//@Composable
//fun ThemeSwitcher(isDarkMode: Boolean, content: @Composable () -> Unit) {
//    MaterialTheme(
//        colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme,
//        typography = Typography, // Default typography
//        content = content
//    )
//}

// DarkLightModeChallengeTheme Composable to set the theme
@Composable
fun DarkLightModeChallengeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
val colorScheme= if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Default typography
        content = content
    )
//    ThemeSwitcher(isDarkMode = isDarkMode, content = content)
}


@Preview(showBackground = true, name = "Light Theme Preview")
@Composable
fun LightThemePreview() {
    DarkLightModeChallengeTheme(darkTheme = false) {
        Text("Light Theme Preview")
    }
}

@Preview(showBackground = true, name = "Dark Theme Preview")
@Composable
fun DarkThemePreview() {
    DarkLightModeChallengeTheme(darkTheme = true) {
        Text("Dark Theme Preview")
    }
}