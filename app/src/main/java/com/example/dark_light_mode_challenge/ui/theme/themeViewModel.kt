package com.example.dark_light_mode_challenge

import android.content.Context
import android.preference.PreferenceManager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import java.util.prefs.Preferences
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class ThemeView(context : Context) : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(loadThemePreference(context))
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme


    // Toggle the theme
    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
        saveThemePreference(_isDarkTheme.value , context )
    }

    // save theme preference in shared preferences
    private fun saveThemePreference(isDark:Boolean,context:Context){
        val sharedPreferences = preferencess.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putBoolean("isDarkTheme",isDark).apply()
    }

    // load theme preferences in SharedPreferences
    private fun loadThemePreference(context : Contexte):Boolean {
        val sjatedPreferneces = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getBoolean("_isDarkTheme",false)

    }

}

val DarkColorScheme = darkColorScheme(
    primary = Color (0xFFBB86FC),
    secondary = Color (0xFF03DAC6),
    background = Color (0xFF121212),
    surface = Color (0xFF121212),
    onPrimary = Color,Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    )

val LightColorScheme = darkColorScheme(
    primary = Color (0xFF6200EE),
    secondary = Color (0xFF03DAC6),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

// themeSwitcher Composable
@Composable
fun ThemeSwitcher(isDarkMode:Boolean, content:@Composable () -> Unit){
    MaterialTheme(
        colorScheme = if (isDarkMode)DarkColorScheme else LightColorScheme,
        content = content
    )
}

@Composable
fun DarkLightModeChallengeTheme(content:@Composable () -> Unit){
    ThemeSwitcher(isDarkMode = true , content = content)
}