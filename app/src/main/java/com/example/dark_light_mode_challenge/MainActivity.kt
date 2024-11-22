package com.example.dark_light_mode_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.example.dark_light_mode_challenge.ui.theme.DarkLightModeChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val themeViewModel : ThemeViewModel by viewModels { themeviewModelFactory(applicationContext)  }
       //  enableEdgeToEdge()
        val themeViewModelFactory = ThemeViewModelFactory(applicationContext)
        val themeViewModel = ViewModelProvider(this, themeViewModelFactory).get(ThemeViewModel::class.java)

        setContent {
            // DarkLightModeChallengeTheme
            val isDarkMode by themeViewModel._isDarkTheme.collectAsState()
            DarkLightModeChallengeTheme {
                ThemeContent(themeViewModel = themeViewModel
                    ,isDarkMode = isDarkMode,)


            }
        }
    }
}

@Composable
fun ThemeContent(themeViewModel: ThemeViewModel , isDarkMode: Boolean) {
    Button(onClick = {themeViewModel.toggleTheme() }) {
        Text(text = "Toggle Theme")
    }
}
//
//@Composable
//fun MainScreen(viewModel: ThemeViewModel){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//            .padding(16.dp)
//    ) {
//        Text(text = "Dark/Light Mode UI",
//            style = MaterialTheme.typography.titleLarge)
//
//        Spacer(modifier = Modifier.padding(16.dp))
//
//        Button(onClick = {viewModel.toggleTheme() }) {
//            Text(text = "Toggle Theme")
//        }
//
//    }
//}
//
//@Composable
//fun DarkLightModeChallengeTheme(isDarkTheme: Boolean, content: @Composable () -> Unit) {
//    MaterialTheme(
//        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme,
//        content = content
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    val themeViewModel = ThemeViewModel(applicationContext= LocalContext.current)
//    DarkLightModeChallengeTheme (isDarkTheme = false){
//        MainScreen(viewModel = ThemeViewModel )
//    }
//}