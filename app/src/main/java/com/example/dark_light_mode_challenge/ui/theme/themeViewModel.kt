package com.example.dark_light_mode_challenge

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel(context : Context) : ViewModel() {

    private val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
   private val _isDarkTheme = MutableStateFlow(loadThemePreference())
    val isDarkTheme : StateFlow<Boolean> = _isDarkTheme

    // Toggle the theme
    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
        saveThemePreference(_isDarkTheme.value)
    }

    // save theme preference in shared preferences
    private fun saveThemePreference(isDark:Boolean){
        sharedPreferences.edit().putBoolean("isDarkTheme",isDark).apply()
    }

    // load theme preferences in SharedPreferences
    private fun loadThemePreference():Boolean {
        return sharedPreferences.getBoolean("_isDarkTheme",false)

    }

}
