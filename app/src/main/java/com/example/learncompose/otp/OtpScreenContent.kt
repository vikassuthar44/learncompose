package com.example.learncompose.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreenContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = Color.White,
                title = {
                    Text(
                        modifier = Modifier
                            .padding(end = 40.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        text = "OTP Verify"
                    )
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .wrapContentSize(),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back"
                    )
                }
            )
        }
    ) {
        var otpValue by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.mobile_verify),
                contentDescription = "Mobile verify"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Verification Code",
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    text = "We have sent the code verification to \nYour Mobile Number",
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        text = "+91-9876543210",
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
                    .background(color = Color.White),
                color = Color.White
            ) {

                BasicTextField(
                    value = otpValue,
                    onValueChange = {
                        if(it.length <= 6) {
                            otpValue = it
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    decorationBox = {
                        Row(horizontalArrangement = Arrangement.Center) {
                            repeat(6) { index ->
                                val char = when {
                                    index >= otpValue.length -> ""
                                    else -> otpValue[index].toString()
                                }
                                val isFocused = otpValue.length == index
                                Text(
                                    modifier = Modifier
                                        .width(40.dp)
                                        .border(
                                            width = if (isFocused) 2.dp else 1.dp,
                                            color = if (isFocused) Color.DarkGray else Color.Gray,
                                            shape = RoundedCornerShape(size = 8.dp)
                                        )
                                        .padding(all = 2.dp),
                                    textAlign = TextAlign.Center,
                                    text = char,
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.h4
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(size = 20.dp))
                    .height(50.dp)
                    .width(300.dp),
                enabled = otpValue.length==6,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button_color),contentColor = Color.White),
                onClick = { }
            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        text = "Submit",
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OtpScreenContentPreview() {
    OtpScreenContent()
}