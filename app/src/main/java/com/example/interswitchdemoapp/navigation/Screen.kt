package com.example.interswitchdemoapp.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Home
import com.example.interswitchdemoapp.R

sealed class Screen(val route: String, @DrawableRes val icon: Int = 0, val name: String = ""){
    object MainScreen: Screen(route = "main_screen", icon = R.drawable.ic_home_24, name = "Home")
    object SettingsScreen: Screen(route = "settings_screen", icon = R.drawable.ic_settings_24, name = "Settings")
}
