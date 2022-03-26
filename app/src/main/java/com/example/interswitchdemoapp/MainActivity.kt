package com.example.interswitchdemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.interswitchdemoapp.navigation.Screen
import com.example.interswitchdemoapp.screens.main_screen.MainScreen
import com.example.interswitchdemoapp.screens.settings_screen.SettingsScreen
import com.example.interswitchdemoapp.ui.theme.InterswitchDemoAppTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screens = listOf(
            Screen.MainScreen,
            Screen.SettingsScreen,
        )

        setContent {
            InterswitchDemoAppTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberAnimatedNavController()

                    Scaffold(bottomBar = {
                        BottomNavigation(
                            backgroundColor = MaterialTheme.colors.primary,
                            elevation = 6.dp
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            screens.forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = screen.icon),
                                            contentDescription = screen.route
                                        )
                                    },
                                    label = { Text(text = screen.name, color = Color.White) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                    ) { innerPadding ->
                        AnimatedNavHost(
                            navController,
                            startDestination = Screen.MainScreen.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.MainScreen.route) {
                                MainScreen(navController = navController)
                            }
                            composable(Screen.SettingsScreen.route) {
                                SettingsScreen(navController = navController)
                            }

                        }
                    }
                }
            }
        }
    }
}