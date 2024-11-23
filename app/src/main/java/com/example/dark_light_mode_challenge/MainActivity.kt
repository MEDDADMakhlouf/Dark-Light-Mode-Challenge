package com.example.dark_light_mode_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.dark_light_mode_challenge.ui.theme.DarkLightModeChallengeTheme
import com.example.dark_light_mode_challenge.ui.theme.ThemeContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val themeViewModel : ThemeViewModel by viewModels { themeviewModelFactory(applicationContext)  }
        //  enableEdgeToEdge()
        val themeViewModel: ThemeViewModel by viewModels { ThemeViewModelFactory(applicationContext) }
        setContent {
            // DarkLightModeChallengeTheme
            val isDarkMode by themeViewModel.isDarkTheme.collectAsState()
            DarkLightModeChallengeTheme (darkTheme = isDarkMode){
                ThemeContent( themeViewModel = themeViewModel )
            }
        }
    }
}