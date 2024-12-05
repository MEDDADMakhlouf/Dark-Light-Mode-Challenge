package com.example.dark_light_mode_challenge.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dark_light_mode_challenge.ThemeViewModel
import androidx.compose.ui.res.painterResource


@Composable
fun ThemeContent(themeViewModel: ThemeViewModel) {
    val isDarkMode = themeViewModel.isDarkTheme.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize(),
//            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = if (isDarkMode) R.drawable.ic_moon else R.drawable.ic_sun
            ),
            ContentDescription=null,
            modifier = Modifier.size(100.dp)
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = if (isDarkMode) "Dark Mode" else "Light Mode",
            fontSize = 24.sp,
            fontweight = FontWeight.Bold,
            color = if (isDarkMode) Color.White else Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Switch(
            checked = isDarkMode,
            onCheckedChange = { themeViewModel.toggleTheme() },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = Color.Gray,
                checkedTrackColor = Color(0xFF2196F3),
                uncheckedTrackColor = Color.LightGray
            )
        )
    }



    }
