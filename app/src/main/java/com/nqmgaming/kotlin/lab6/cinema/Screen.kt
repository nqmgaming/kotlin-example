package com.nqmgaming.kotlin.lab6.cinema

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object BookTicket : Screen(route = "book_ticket")
}