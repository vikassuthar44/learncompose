package com.example.learncompose.animation

import android.animation.TimeInterpolator
import android.view.animation.BounceInterpolator
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationContent() {
    val show = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = show.value,
            enter = scaleIn(
                animationSpec = tween(durationMillis = 1000,
                    easing = BounceInterpolator().toEasing())
            ),
            exit = scaleOut(animationSpec = tween(durationMillis = 1000))
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(color = Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "icon",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            show.value = !show.value
        }) {
            Text(text = "Hide")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AnimationContentPreview() {
    AnimationContent()
}

fun TimeInterpolator.toEasing() = Easing {
        x -> getInterpolation(x)
}