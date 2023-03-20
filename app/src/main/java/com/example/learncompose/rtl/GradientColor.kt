package com.example.learncompose.rtl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientColor() {
    Box(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Blue,
                    ),
                    //startX = Offset()
                )
            )
            .width(24.dp)
            .fillMaxHeight()
    )
}

@Preview(showSystemUi = true)
@Composable
fun GradientColorPreview() {
    GradientColor()
}