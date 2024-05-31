package com.nqmgaming.kotlin.lab6.cinema.model.entities.seat

data class Seat(
    var row: Char = 'A',
    val number: Int = 0,
    val status: SeatStatus = SeatStatus.EMPTY
)