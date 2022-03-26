package com.example.interswitchdemoapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.interswitchdemoapp.navigation.Screen
import com.example.interswitchdemoapp.network.ConnectionState
import com.example.interswitchdemoapp.screens.main_screen.MainScreen
import com.example.interswitchdemoapp.screens.settings_screen.SettingsScreen
import com.example.interswitchdemoapp.ui.theme.InterswitchDemoAppTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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

                    val scaffoldState = rememberScaffoldState()
                    val coroutineScope = rememberCoroutineScope()

                    @ExperimentalCoroutinesApi
                    @Composable
                    fun connectivityState(): State<ConnectionState> {
                        val context = LocalContext.current

                        return produceState(initialValue = context.currentConnectivityState) {
                            context.observeConnectivityAsFlow().collect { value = it }
                        }
                    }


                    @Composable
                    fun ConnectivityStatus(scaffoldState: ScaffoldState) {
                        // This will cause re-composition on every network state change
                        val connection by connectivityState()

                        val isConnected = connection == ConnectionState.Available

                        LaunchedEffect(scaffoldState.snackbarHostState) {
                            coroutineScope.launch {
                                if (isConnected) {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        "Connected",
                                        duration = SnackbarDuration.Long
                                    )

                                } else {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        "No Connection",
                                        duration = SnackbarDuration.Long
                                    )
                                }
                            }
                        }
                    }

                    val navController = rememberAnimatedNavController()

                    Scaffold(
                        scaffoldState = scaffoldState,
                        bottomBar = {
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

                        ConnectivityStatus(scaffoldState = scaffoldState)

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

    private val Context.currentConnectivityState: ConnectionState
        get() {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return getCurrentConnectivityState(connectivityManager)
        }

    private fun getCurrentConnectivityState(
        connectivityManager: ConnectivityManager
    ): ConnectionState {
        val connected = connectivityManager.allNetworks.any { network ->
            connectivityManager.getNetworkCapabilities(network)
                ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                ?: false
        }

        return if (connected) ConnectionState.Available else ConnectionState.Unavailable
    }

    fun Context.observeConnectivityAsFlow() = callbackFlow {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val callback = NetworkCallback { connectionState -> trySend(connectionState) }

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(networkRequest, callback)

        // Set current state
        val currentState = getCurrentConnectivityState(connectivityManager)
        trySend(currentState)

        // Remove callback when not used
        awaitClose {
            // Remove listeners
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }

    private fun NetworkCallback(callback: (ConnectionState) -> Unit): ConnectivityManager.NetworkCallback {
        return object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                callback(ConnectionState.Available)
            }

            override fun onLost(network: Network) {
                callback(ConnectionState.Unavailable)
            }
        }
    }
}