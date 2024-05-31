package com.nqmgaming.kotlin.lab6.cinema.presentation.screens.ticket

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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nqmgaming.kotlin.R
import com.nqmgaming.kotlin.lab6.cinema.Screen
import com.nqmgaming.kotlin.lab6.cinema.domain.entities.seat.Seat
import com.nqmgaming.kotlin.lab6.cinema.domain.entities.seat.SeatStatus
import com.nqmgaming.kotlin.lab6.cinema.presentation.components.SeatComposable
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

    var selectedSeatsCount by remember { mutableStateOf(0) }
    val maxSeatsLimit = 5

    CinemaSeatBookingScreen(
        seats = seats,
        totalSeatsPerRow = 9,
        selectedSeatsCount = selectedSeatsCount,
        maxSeatsLimit = maxSeatsLimit,
        onSeatSelected = { selectedSeatsCount++ },
        onSeatDeselected = { selectedSeatsCount-- },
        onConfirm = {
            navController.navigate(route = Screen.Confirmation.route)
        }
    )
}

@Composable
fun CinemaSeatBookingScreen(
    seats: List<Seat>,
    totalSeatsPerRow: Int,
    selectedSeatsCount: Int,
    maxSeatsLimit: Int,
    onSeatSelected: () -> Unit,
    onSeatDeselected: () -> Unit,
    onConfirm: () -> Unit
) {
    var totalPrice by remember { mutableStateOf(0f) }

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
                SeatComposable(
                    seat = seat,
                    clickable = selectedSeatsCount < maxSeatsLimit || seat.status == SeatStatus.SELECTED,
                    onSeatSelected = { price -> totalPrice += price },
                    onSeatDeselected = { price -> totalPrice -= price }
                )
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
            SeatComposable(exampleEmptySeat, false, {}, {})
            Text(
                text = "Available",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleSelectedSeat, false, {}, {})
            Text(
                text = "Selected",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleBookedSeat, false, {}, {})
            Text(
                text = "Booked",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
        }
        Text(
            text = "Total Price: $${"%.2f".format(totalPrice)}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(
            onClick = {
                onConfirm()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Confirm Booking")
        }
    }
}
