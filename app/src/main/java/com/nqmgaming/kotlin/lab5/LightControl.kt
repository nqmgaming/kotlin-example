package com.nqmgaming.kotlin.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nqmgaming.kotlin.R

@Composable
fun LightControl() {

    var lightOn by remember {
        mutableStateOf(false)
    }

    var lightResource = if (lightOn) R.drawable.light_bulb_on else R.drawable.light_bulb_off

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = lightResource),
            contentDescription = "Light off",
            modifier = Modifier.size(300.dp)
        )
        Switch(checked = lightOn, onCheckedChange = { lightOn = it })
    }

}

@Preview(showSystemUi = true)
@Composable
fun LightControlPreview() {
    LightControl()
}