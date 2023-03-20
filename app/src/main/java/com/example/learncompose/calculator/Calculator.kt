package com.example.learncompose.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorApp() {
    var expression by remember {
        mutableStateOf("")
    }
    var enterText by remember {
        mutableStateOf("0")
    }
    var previous by remember {
        mutableStateOf("")
    }
    var isSymbolClick by remember {
        mutableStateOf(false)
    }
    var previousSymbole by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(modifier = Modifier.padding(all = 20.dp), horizontalAlignment = Alignment.End) {
                Text(text = expression, color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.W900)
                Text(text = enterText, color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.W900, maxLines = 1, textAlign = TextAlign.End)
            }

        }

        Box(
            modifier = Modifier
                .weight(5f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SingleView(
                        text = "AC",
                        color = Color(0xFFA5A5A5)
                    ) {
                        expression = ""
                        enterText = "0"
                        previous = ""
                        isSymbolClick = false
                        previousSymbole = ""
                    }
                    SingleView(
                        text = "+/-",
                        color = Color(0xFFA5A5A5)
                    ) {

                    }
                    SingleView(
                        text = "%",
                        color = Color(0xFFA5A5A5)
                    ) {
                        expression = "% $enterText"
                        enterText = "=${enterText.toInt() / 100}"
                    }
                    SingleView(
                        text = "/",
                        color = Color(0xFFff9f0c)
                    ) {
                        if(previous.isEmpty()) {
                            previous = enterText
                            isSymbolClick = true
                            previousSymbole = "/"
                        } else {
                            val result = when(previousSymbole) {
                                "/" -> previous.toInt()/enterText.toInt()
                                "X" -> previous.toInt() * enterText.toInt()
                                "-" -> previous.toInt() - enterText.toInt()
                                "+" -> previous.toInt() + enterText.toInt()
                                else -> {
                                    ""
                                }
                            }.toString()
                            expression = "= $result"
                            previous = result
                            previousSymbole = "/"
                            enterText = "0"
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SingleView(
                        text = "7"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "8"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "9"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "X",
                        color = Color(0xFFff9f0c)
                    ) {
                        if(previous.isEmpty()) {
                            previous = enterText
                            isSymbolClick = true
                            previousSymbole = "X"
                        } else {
                            val result = when(previousSymbole) {
                                "/" -> previous.toInt()/enterText.toInt()
                                "X" -> previous.toInt() * enterText.toInt()
                                "-" -> previous.toInt() - enterText.toInt()
                                "+" -> previous.toInt() + enterText.toInt()
                                else -> {
                                    ""
                                }
                            }.toString()
                            expression = "= $result"
                            previous = result
                            previousSymbole = "X"
                            enterText = "0"
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SingleView(
                        text = "4"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "5"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "6"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "-",
                        color = Color(0xFFff9f0c)
                    ) {
                        if(previous.isEmpty()) {
                            previous = enterText
                            isSymbolClick = true
                            previousSymbole = "-"
                        } else {
                            val result = when(previousSymbole) {
                                "/" -> previous.toInt()/enterText.toInt()
                                "X" -> previous.toInt() * enterText.toInt()
                                "-" -> previous.toInt() - enterText.toInt()
                                "+" -> previous.toInt() + enterText.toInt()
                                else -> {
                                    ""
                                }
                            }.toString()
                            expression = "= $result"
                            previous = result
                            previousSymbole = "-"
                            enterText = "0"
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SingleView(
                        text = "1"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "2"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "3"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "+",
                        color = Color(0xFFff9f0c)
                    ) {
                        if(previous.isEmpty()) {
                            previous = enterText
                            isSymbolClick = true
                            previousSymbole = "+"
                        } else {
                            val result = when(previousSymbole) {
                                "/" -> previous.toInt()/enterText.toInt()
                                "X" -> previous.toInt() * enterText.toInt()
                                "-" -> previous.toInt() - enterText.toInt()
                                "+" -> previous.toInt() + enterText.toInt()
                                else -> {
                                    ""
                                }
                            }.toString()
                            expression = "= $result"
                            previous = result
                            previousSymbole = "+"
                            enterText = "0"
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DoubleView(
                        text = "0"
                    ) {
                        if(enterText == "0") {
                            enterText = it
                        } else if(isSymbolClick){
                            isSymbolClick = false
                            enterText = it
                        } else {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "."
                    ) {
                        if(!enterText.contains(".")) {
                            enterText += it
                        }
                    }
                    SingleView(
                        text = "=",
                        color = Color(0xFFff9f0c)
                    ) {
                        if(previous.isNotEmpty()) {
                            val result = when(previousSymbole) {
                                "/" -> previous.toInt()/enterText.toInt()
                                "X" -> previous.toInt() * enterText.toInt()
                                "-" -> previous.toInt() - enterText.toInt()
                                "+" -> previous.toInt() + enterText.toInt()
                                else -> {
                                    ""
                                }
                            }.toString()
                            expression = "= $result"
                            previous = ""
                            previousSymbole = ""
                            enterText = "0"
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SingleView(
    text: String,
    color: Color = Color(0xFF333333),
    onPress: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .size(80.dp)
            .clickable {
                onPress(text)
            },
        backgroundColor = color,
        shape = CircleShape,
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.background(color = Color.Transparent),
                text = text,
                fontSize = 32.sp,
                fontWeight = FontWeight.W700,
                color = Color.White
            )
        }
    }
}

@Composable
fun DoubleView(
    text: String,
    color: Color = Color(0xFF333333),
    onPress: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .width(180.dp)
            .clickable {
                onPress(text)
            },
        backgroundColor = color,
        shape = CircleShape,
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .background(color = Color.Transparent),
                text = text,
                fontSize = 32.sp,
                fontWeight = FontWeight.W700,
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SingleViewPreview() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
    CalculatorApp()
}