package com.example.interswitchdemoapp.screens.settings_screen

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.interswitchdemoapp.R
import com.example.interswitchdemoapp.common.CustomButton
import com.example.interswitchdemoapp.navigation.Screen
import com.example.interswitchdemoapp.screens.main_screen.MainScreen
import com.example.interswitchdemoapp.state_holders.MainScreenStateHolder
import com.example.interswitchdemoapp.state_holders.SettingScreenStateHolder
import com.example.presentation.viewmodels.MainViewModel
import com.example.presentation.viewmodels.SettingsViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
private fun rememberSettingsScreenState(
    viewModel: SettingsViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavController,
    resources: Resources = LocalContext.current.resources,
) = remember {
    SettingScreenStateHolder(scaffoldState, coroutineScope, viewModel, navController, resources)
}

@Composable
fun SettingsScreen(navController: NavController) {

    val state = rememberSettingsScreenState(navController = navController)

    Scaffold(
        scaffoldState = state.scaffoldState,
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

        if (state.message.isNotEmpty() and state.message.isNotBlank()) {
            SideEffect{
                state.coroutineScope.launch {
                    state.showSnackBar(state.message)
                    state.message = ""
                }
            }
        }

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
                state.clearCacheData()
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController())
}