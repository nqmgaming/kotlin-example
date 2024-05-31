package com.nqmgaming.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nqmgaming.kotlin.lab3.CounterCard
import com.nqmgaming.kotlin.lab3.Lab3Screen
import com.nqmgaming.kotlin.lab6.cinema.Screen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.BookTicketScreen
import com.nqmgaming.kotlin.lab6.cinema.ui.screens.MovieScreen
import com.nqmgaming.kotlin.ui.theme.KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(
                        route = Screen.Home.route
                    ) {
                        MovieScreen()
                    }
                    composable(
                        route = Screen.BookTicket.route
                    ) {
                        BookTicketScreen()
                    }
                }
            }
        }
    }
}
