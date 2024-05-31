package com.nqmgaming.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nqmgaming.kotlin.lab6.cinema.Screen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.confirm.ConfirmationScreen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.login.LoginScreen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.ticket.BookTicketScreen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.movie.MovieScreen
import com.nqmgaming.kotlin.ui.theme.KotlinTheme

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
                        MovieScreen(navController = navController)
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
