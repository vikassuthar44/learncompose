package com.example.learncompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Functions() {
    Surface(
        modifier = Modifier.wrapContentSize().padding(all = 20.dp),
        shape = RoundedCornerShape(size = 20.dp),
        border = BorderStroke(width = 2.dp, color = Color.Gray)
    ) {
        var value by remember {
            mutableStateOf("")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Face, contentDescription = "")
            Text(text = "www.facebook.com")
            TextField(value = value, onValueChange = {
                value = it
            })
        }
    }
}