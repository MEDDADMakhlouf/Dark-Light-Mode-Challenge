package com.example.dark_light_mode_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dark_light_mode_challenge.ui.theme.DarkLightModeChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //  enableEdgeToEdge()
        setContent {
            // DarkLightModeChallengeTheme
            DarkLightModeChallengeTheme {
                val themeViewModel:ThemeViewModel = viewModel(factory = ThemeViewModelFactory(applicationContext))
                val isDarktheme = themeViewModel.ieDarkTheme.collectAsState()

                //wrap your screen content in the thrme manager to switch between
                ThemeSwitcher(isDarkMode = isDarktheme.value){
                    MainScreen(themeViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: ThemeViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(16.dp)
    ) {
        Text(text = "Dark/Light Mode UI", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {viewModel.toggleTheme()}) {
            Text(text = "Toggle Theme")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    DarkLightModeChallengeTheme {
        MainScreen(viewModel = ThemeViewModel())
    }