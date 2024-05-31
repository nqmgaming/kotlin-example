package com.nqmgaming.kotlin.lab6.cinema

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
    data object Home : Screen(route = "home")
    data object BookTicket : Screen(route = "book_ticket")
    data object Confirmation : Screen(route = "confirmation")
}