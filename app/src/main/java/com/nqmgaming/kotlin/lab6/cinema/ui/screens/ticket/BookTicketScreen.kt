package com.nqmgaming.kotlin.lab6.cinema.ui.screens.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nqmgaming.kotlin.R
import com.nqmgaming.kotlin.lab6.cinema.model.entities.seat.Seat
import com.nqmgaming.kotlin.lab6.cinema.model.entities.seat.SeatStatus
import com.nqmgaming.kotlin.lab6.cinema.ui.components.SeatComposable
import com.nqmgaming.kotlin.lab6.cinema.utils.GeneratorSeat

@Composable
fun BookTicketScreen(
    navController: NavController
) {
    val seats = GeneratorSeat.createTheaterSeating(
        totalRows = 8,
        totalSeatsPerRow = 9,
        aislePositionInRow = 4,
        aislePositionInColumn = 5
    )

    CinemaSeatBookingScreen(
        seats = seats,
        totalSeatsPerRow = 9
    )
}

@Composable
fun CinemaSeatBookingScreen(
    seats: List<Seat>,
    totalSeatsPerRow: Int
) {
    val textModifier = Modifier.padding(
        end = 16.dp, start =
        4.dp
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_screen),
            contentDescription = "Screen"
        )
        Text(
            "Screen",
            modifier = Modifier.padding(bottom = 16.dp),
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(totalSeatsPerRow)) {
            items(seats.size) { index ->
                val seat = seats[index]
                SeatComposable(seat)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val exampleEmptySeat = remember {
                Seat(
                    'X', 1,
                    SeatStatus.EMPTY
                )
            }
            val exampleSelectedSeat = remember {
                Seat(
                    'Y', 1,
                    SeatStatus.SELECTED
                )
            }
            val exampleBookedSeat = remember {
                Seat(
                    'Z', 1,
                    SeatStatus.BOOKED
                )
            }
            SeatComposable(exampleEmptySeat, false)
            Text(
                text = "Available",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleSelectedSeat, false)
            Text(
                text = "Selected",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleBookedSeat, false)
            Text(
                text = "Booked",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
        }
    }
}
