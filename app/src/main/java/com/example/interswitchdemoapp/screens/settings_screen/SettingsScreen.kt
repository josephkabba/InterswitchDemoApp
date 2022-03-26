package com.example.interswitchdemoapp.screens.settings_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(navController: NavController){
    LazyColumn {

    }
}

@Preview
@Composable
private fun SettingsScreenPreview(){
    SettingsScreen(navController = rememberNavController())
}