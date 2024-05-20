package com.nqmgaming.kotlin.lab4

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nqmgaming.kotlin.R
import com.nqmgaming.kotlin.core.components.IconButton

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFda4c56),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Hey")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF222222),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(" Champ! ${"\uD83D\uDC4B"}")
                }

            },
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF000000), fontSize = 16.sp)) {
                append("Welcome back to ")
            }
            withStyle(style = SpanStyle(color = Color(0xFFda4c00), fontSize = 16.sp)) {
                append("UinSports.com")
            }
        }, modifier = Modifier.padding(bottom = 3.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_ball),
                contentDescription = "Google",
                modifier = Modifier.size(60.dp),
            )
            Text(
                text = "UinSports", style = TextStyle(
                    color = Color(0xFFda4c56),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            maxLines = 1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = Color(0xFFda4c56)
                )
            },
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf5f5f5))
                .padding(bottom = 10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf5f5f5))
                .padding(bottom = 10.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password",
                    tint = Color(0xFFda4c56)
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF000000), fontSize = 16.sp)) {
                append("Forgot your password? ")
            }
            withStyle(style = SpanStyle(color = Color(0xFFda4c00), fontSize = 16.sp)) {
                append("Reset here")
            }
        }, modifier = Modifier.padding(top = 10.dp))

        Button(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        "Email: $email, Password: $password",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFda4c56),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Sign in",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF000000), fontSize = 16.sp)) {
                            append("Don't have an account? ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFFda4c00), fontSize = 16.sp)) {
                            append("Sign up")
                        }
                    }
                )

                Text(
                    text = "Or sign with",
                    style = TextStyle(color = Color.Gray, fontSize = 13.sp),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Row {
                    IconButton(
                        icon = R.drawable.ic_google,
                        content = "Google",
                        modifier = Modifier.padding(end = 10.dp)
                    )

                    IconButton(icon = R.drawable.ic_facebook, content = "Facebook")
                }
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}