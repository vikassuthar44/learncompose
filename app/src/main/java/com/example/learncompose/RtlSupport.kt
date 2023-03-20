package com.example.learncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val input = remember {
            mutableStateOf(TextFieldValue(text = ""))
        }
        val firstLatter = remember {
            mutableStateOf(false)
        }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Blue.copy(alpha = 0.1f))
                    .padding(top = 20.dp, bottom = 20.dp),
                value = input.value,
                onValueChange = { newTextFieldValue ->
                    input.value = newTextFieldValue
                },
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 25.sp,
                    textDirection = TextDirection.Content,
                    textAlign = TextAlign.Start
                ),
                onTextLayout = { it ->
                    val position = it.layoutInput.text.toString().indexOf("\n")
                    if(it.layoutInput.text.toString() == "\n") {
                        firstLatter.value
                    }
                }
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    locale = "ar"
)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}