package com.example.testapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.example.testapp.presentation.theme.TestAppTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.swayy.cooperativebank.util.Route
import androidx.navigation.compose.composable
import com.example.testapp.presentation.screens.HomeScreen
import com.example.testapp.presentation.screens.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                val navController = rememberAnimatedNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.LOGIN_SCREEN
                    ) {
                        composable(route = Route.LOGIN_SCREEN){
                            LoginScreen(navigateToWelcomeScreen = {
                                navController.navigate(Route.HOME)
                            })
                        }
                        composable(route = Route.HOME){
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}


