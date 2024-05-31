package com.nqmgaming.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nqmgaming.kotlin.lab6.cinema.Screen
import com.nqmgaming.kotlin.lab6.cinema.presentation.screens.confirm.ConfirmationScreen
import com.nqmgaming.kotlin.lab6.cinema.presentation.screens.login.LoginScreen
import com.nqmgaming.kotlin.lab6.cinema.presentation.screens.ticket.BookTicketScreen
import com.nqmgaming.kotlin.lab6.cinema.presentation.screens.movie.MovieScreen
import com.nqmgaming.kotlin.lab6.cinema.presentation.screens.movie.MovieViewModel
import com.nqmgaming.kotlin.ui.theme.KotlinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(
                        route = Screen.Login.route
                    ) {
                        LoginScreen(navController = navController)
                    }
                    composable(
                        route = Screen.Home.route
                    ) {
                        MovieScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = Screen.BookTicket.route
                    ) {
                        BookTicketScreen(navController = navController)
                    }
                    composable(
                        route = Screen.Confirmation.route
                    ) {
                        ConfirmationScreen(navController = navController)
                    }
                }
            }
        }
    }
}
