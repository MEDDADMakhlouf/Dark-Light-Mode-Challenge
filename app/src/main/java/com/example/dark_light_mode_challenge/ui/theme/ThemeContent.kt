package com.example.dark_light_mode_challenge.ui.theme

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.dark_light_mode_challenge.ThemeViewModel

@Composable
fun ThemeContent(themeViewModel: ThemeViewModel) {
    val isDarkMode = themeViewModel.isDarkTheme.collectAsState()
    Button(onClick = { themeViewModel.toggleTheme() }) {
        Text(text =if(isDarkMode.value)"Switch to Light Mode" else "Switch to Dark Mode")  }
}
    @Preview(showBackground = true, name = "Light theme Content")
    @Composable
    fun ThemeContentPreviewLight() {
        DarkLightModeChallengeTheme(darkTheme = false) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Toggle Theme")

            }
        }
    }

    @Preview(showBackground = true, name = "Dark theme Content")
    @Composable
    fun ThemeContentPreviewDark() {
        DarkLightModeChallengeTheme(darkTheme = true) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Toggle Theme")
            }
        }
    }
