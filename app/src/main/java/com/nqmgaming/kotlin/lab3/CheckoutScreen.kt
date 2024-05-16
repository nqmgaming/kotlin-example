package com.nqmgaming.kotlin.lab3

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nqmgaming.kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckoutScreen() {
    var selectedPaymentMethod by remember { mutableStateOf(paymentMethods[0]) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Checkout", style = TextStyle(
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF9800).copy(
                        alpha = 0.9f
                    ),
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

            )
        },
        bottomBar = {
            //create a bottom bar
            BottomAppBar {
                BottomNavigationBar()
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),

            ) {
            item {
                AddressSection()
                Spacer(modifier = Modifier.height(16.dp))
                PaymentSection(
                    selectedPaymentMethod,
                    onPaymentMethodSelected = { selectedPaymentMethod = it })
                ButtonCheckout(modifier = Modifier.fillMaxWidth())
            }

        }
    }
}

@Composable
private fun AddressSection(
    modifier: Modifier = Modifier
) {

    Column {
        Text(
            text = "Address to deliver: ",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Image(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(35.dp),
                colorFilter = ColorFilter.tint(Color(0xFFD1360F).copy(alpha = 0.9f))

            )
            Text(
                text = "123 Nguyen Van Linh, \n District 7, Ho Chi Minh City",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun PaymentSection(
    selectedPaymentMethod: PaymentMethod,
    onPaymentMethodSelected: (PaymentMethod) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
    ) {
        Text(
            text = "Select payment method: ",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        paymentMethods.forEach { paymentMethod ->
            PaymentMethodItem(
                paymentMethod = paymentMethod,
                isSelected = paymentMethod == selectedPaymentMethod,
                onPaymentMethodSelected = onPaymentMethodSelected
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PaymentMethodItem(
    paymentMethod: PaymentMethod,
    isSelected: Boolean,
    onPaymentMethodSelected: (PaymentMethod) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {
            onPaymentMethodSelected(paymentMethod)
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .drawBehind {
                if (isSelected) {
                    drawRect(
                        color = Color(0xFFFF9800),
                        topLeft = Offset(0f, 0f),
                        size = size
                    )
                }
            }
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(paymentMethod.backgroundColor)
                .padding(16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = paymentMethod.icon),
                contentDescription = null,
                modifier = Modifier.size(35.dp),
            )
            Text(
                text = paymentMethod.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )

            RadioButton(
                selected = isSelected,
                onClick = { onPaymentMethodSelected(paymentMethod) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFFFFA000),
                    unselectedColor = Color(0xFFFBC02D)
                )
            )
        }

    }
}

@Composable
private fun ButtonCheckout(
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(horizontal = 20.dp)
            .height(50.dp)
            .shadow(10.dp, shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF9800)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = "Checkout", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )
        )
    }
}

@Composable
private fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFFF9800).copy(alpha = 0.9f),
    ) {
        NavigationBarItem(
            alwaysShowLabel = true,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            selected = true,
            onClick = {
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color(0xFFFFA000),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            alwaysShowLabel = true,
            icon = { Icon(Icons.Default.LocationOn, contentDescription = "Location") },
            label = { Text(text = "Location") },
            selected = false,
            onClick = {
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color(0xFFFFA000),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            alwaysShowLabel = true,
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text(text = "Profile") },
            selected = false,
            onClick = {
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color(0xFFFFA000),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            alwaysShowLabel = true,
            icon = { Icon(Icons.Default.Settings, contentDescription = "Setting") },
            label = { Text(text = "Setting") },
            selected = false,
            onClick = {
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color(0xFFFFA000),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
    }
}

data class PaymentMethod(
    val name: String,
    @DrawableRes val icon: Int,
    val id: Int,
    val backgroundColor: Color
)

val paymentMethods = listOf(
    PaymentMethod(
        name = "Cash on delivery",
        icon = R.drawable.ic_money,
        id = 0,
        backgroundColor = Color(0xFF8BC852)
    ),
    PaymentMethod(
        name = "Credit card",
        icon = R.drawable.ic_visa,
        id = 1,
        backgroundColor = Color(0xFF22246E)
    ),
    PaymentMethod(
        name = "Paypal",
        icon = R.drawable.ic_paypal,
        id = 2,
        backgroundColor = Color(0xFF001869)
    )
)


@Preview(showSystemUi = true)
@Composable
fun PreviewCheckoutScreen() {
    CheckoutScreen()
}