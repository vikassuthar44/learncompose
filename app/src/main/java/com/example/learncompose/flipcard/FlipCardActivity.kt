package com.example.learncompose.flipcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.learncompose.R

class FlipCardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CardFlip()
        }
    }
}

@Composable
fun CardFlip() {
    var rotated by remember {
        mutableStateOf(false)
    }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500)
    )

    val animationFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(500)
    )

    val animationBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500)
    )

    val animationColor by animateColorAsState(
        targetValue = if (rotated) Color.Transparent else Color.Transparent,
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
       /* Card(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                    shape = RoundedCornerShape(size = 20.dp)
                }
                .clickable {
                    rotated = !rotated
                },
            backgroundColor = animationColor
        ) {*/

           /* val painterResource =
                if (rotated) painterResource(id = R.drawable.atm_front) else painterResource(
                    id = R.drawable.atm_back
                )*/
            /*Image(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .graphicsLayer {
                        alpha = if (rotated) animationBack else animationFront
                        rotationY = rotation
                        cameraDistance = 12 * density
                        shape = RoundedCornerShape(size = 20.dp)
                    }
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(size = 20.dp))
                    .clickable {
                               rotated = !rotated
                    },
                //painter = painterResource,
                contentDescription = "atm image",
                contentScale = ContentScale.Crop
            )*/
            /*Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.graphicsLayer {
                        alpha = if (rotated) animationBack else animationFront
                        rotationY = rotation
                    },
                    text = if (rotated) "Front" else "Back",
                    color = Color.White,
                )
            }*/
       // }
    }
}