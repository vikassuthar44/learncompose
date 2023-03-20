package com.example.learncompose.animation.fab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FabScreen() {
    Card(
        elevation = 8.dp,
        shape = CircleShape,
        backgroundColor = Color.Blue,
        modifier = Modifier.clickable {

        }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FabScreenPreview() {
    FabScreen()
}