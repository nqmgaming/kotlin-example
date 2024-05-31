package com.nqmgaming.kotlin.lab6.cinema.utils

import com.nqmgaming.kotlin.lab6.cinema.model.entities.seat.Seat
import com.nqmgaming.kotlin.lab6.cinema.model.entities.seat.SeatStatus
import kotlin.random.Random

object GeneratorSeat {
    fun createTheaterSeating(
        totalRows: Int,
        totalSeatsPerRow: Int,
        aislePositionInRow: Int,
        aislePositionInColumn: Int
    ): List<Seat> {
        val seats = mutableListOf<Seat>()
        for (rowIndex in 0 until totalRows) {
            for (seatIndex in 1..totalSeatsPerRow) {
                val adjustedRowIndex = if (rowIndex >=
                    aislePositionInRow
                ) rowIndex - 1 else rowIndex
                val adjustedSeatIndex = if (seatIndex >= aislePositionInColumn)
                    seatIndex - 1 else seatIndex
                val isAisleRow = rowIndex == aislePositionInRow
                val isAisleColumn = seatIndex ==
                        aislePositionInColumn
                val status = when {
                    isAisleRow || isAisleColumn -> SeatStatus.AISLE
                    else -> if (Random.nextInt(0, 99) % 2 == 0)
                        SeatStatus.BOOKED else SeatStatus.EMPTY
                }
                seats.add(
                    Seat(
                        row = 'A' + adjustedRowIndex,
                        number = adjustedSeatIndex,
                        status = status
                    )
                )
            }
        }
        return seats
    }
}