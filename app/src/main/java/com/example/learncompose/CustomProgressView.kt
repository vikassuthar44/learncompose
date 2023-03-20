/*
package com.example.learncompose

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.Integer.min
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

private const val NumDots = 5
private val MainDotSize = 24.dp
private const val AnimationDuration = 2000
private const val AnimationSegment = AnimationDuration / 10

@Composable
fun Dot(
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = color)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DotPreview() {
    Dot(
        color = Color.Green,
        modifier = Modifier
            .padding(all = 32.dp)
            .requiredSize(32.dp)
    )
}

@Composable
fun CustomProgress(
    modifier: Modifier = Modifier,
    color: Color = Color.Green
) {
    val animatedValues = List(NumDots) { index ->
        var animateValue by remember(key1 = Unit) {
            mutableStateOf(0f)
        }

        LaunchedEffect(key1 = Unit) {
            animate(
                initialValue = 0f,
                targetValue = (2f * PI).toFloat(),
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = AnimationDuration),
                    repeatMode = RepeatMode.Restart,
                    initialStartOffset = StartOffset(offsetMillis = 100 * index)
                )
            ) { value, _ ->
                animateValue = value
            }
        }
        animateValue
    }

    Layout(
        // 1
        content = {
            // 2
            val minFactor = .3f
            val step = minFactor / NumDots
            repeat(NumDots) { index ->
                // 3
                val size = MainDotSize * (1f - index * step)
                Dot(
                    color = color,
                    modifier = Modifier.requiredSize(size)
                )
            }
        },
        modifier = modifier,
    ) { measurables, constraints ->

        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0
        )

        val placeable = measurables.map { measurable ->
            measurable.measure(looseConstraints)
        }

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ) {

            //middle point of content
            val radius = (min(constraints.maxWidth, constraints.maxHeight) / 2f).roundToInt()

            placeable.forEachIndexed { index, placeable ->
                val animatedValue = animatedValues[index]
                val x = (radius * sin(animatedValue)).roundToInt()
                val y = (radius - radius * cos(animatedValue)).roundToInt()
                placeable.place(
                    x = x,
                    y = y
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CustomProgressPreview() {
    CustomProgress(

    )
}*/
