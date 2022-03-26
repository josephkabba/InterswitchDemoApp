package com.example.interswitchdemoapp.state_holders

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.navigation.NavController
import com.example.presentation.viewmodels.SettingsViewModel

class SettingScreenStateHolder(
    val scaffoldState: ScaffoldState,
    val viewModel: SettingsViewModel,
    val navController: NavController,
    private val resources: Resources,
) {

}