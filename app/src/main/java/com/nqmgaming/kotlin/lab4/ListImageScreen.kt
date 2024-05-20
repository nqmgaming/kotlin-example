package com.nqmgaming.kotlin.lab4

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nqmgaming.kotlin.R

@Composable
fun ListImageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeadingImage(
            icon = R.drawable.ic_ball,
            modifier = Modifier
                .size(100.dp)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        )
        RowImage(
            icon = listOf(
                R.drawable.ic_ball,
                R.drawable.ic_basketball,
                R.drawable.ic_football,
                R.drawable.ic_tennis,
                R.drawable.ic_volleyball,
            ),
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
        ColumnImage(
            icon = listOf(
                R.drawable.ic_ball,
                R.drawable.ic_basketball,
                R.drawable.ic_football,
                R.drawable.ic_tennis,
                R.drawable.ic_volleyball,
            ),
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
    }
}

@Composable
private fun HeadingImage(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = "Logo",
        modifier = modifier
    )
}

@Composable
private fun RowImage(
    modifier: Modifier = Modifier,
    @DrawableRes icon: List<Int>,
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
    ) {
        icon.forEach {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(end = 10.dp)
                    .background(
                        Color.Yellow,
                        shape = RoundedCornerShape(10)
                    )
            )
        }
    }
}

@Composable
private fun ColumnImage(
    modifier: Modifier = Modifier,
    @DrawableRes icon: List<Int>,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        icon.forEach {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxSize()
                    .size(200.dp)
                    .padding(bottom = 10.dp)
                    .background(
                        Color.Green,
                        shape = RoundedCornerShape(10)
                    )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListImageScreenPreview() {
    ListImageScreen()
}