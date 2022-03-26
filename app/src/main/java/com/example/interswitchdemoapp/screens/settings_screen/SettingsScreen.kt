package com.example.interswitchdemoapp.screens.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.interswitchdemoapp.R
import com.example.interswitchdemoapp.common.CustomButton
import com.example.interswitchdemoapp.navigation.Screen
import com.example.interswitchdemoapp.screens.main_screen.MainScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 6.dp,
                backgroundColor = Color.White,
                contentPadding = PaddingValues(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.settings),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = MaterialTheme.colors.primary
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                modifier = Modifier.size(200.dp),
                roundedCornerShape = { RoundedCornerShape(200.dp) },
                title = "Clear Data"
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController())
}