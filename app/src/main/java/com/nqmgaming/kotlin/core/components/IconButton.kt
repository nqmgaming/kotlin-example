package com.nqmgaming.kotlin.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nqmgaming.kotlin.R

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    content: String
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(top = 10.dp)
            .width(150.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            1.dp, Color.Gray.copy(
                alpha = 0.2f
            )
        )
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = content,
            modifier = Modifier.size(25.dp),
        )
    }
}