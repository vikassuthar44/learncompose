package com.example.learncompose.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {
    fun getRandomColor() = Color(
        red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256),
        alpha = 255
    )
}