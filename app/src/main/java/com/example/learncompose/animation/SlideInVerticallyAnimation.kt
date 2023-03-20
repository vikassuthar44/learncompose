package com.example.learncompose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class SlideInVerticallyAnimationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ModalBottomSheetSample()
        }
    }
}
@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ModalBottomSheetSample() {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)
    val scope = rememberCoroutineScope()
    val initialValue = remember {
        mutableStateOf("")
    }
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            Column {
                TextField(value = initialValue.value, onValueChange = {
                    initialValue.value = it
                } )
                LazyColumn {
                    items(50) {
                        ListItem(
                            text = { Text("Item $it") },
                            icon = {
                                Icon(
                                    Icons.Default.Favorite,
                                    contentDescription = "Localized description"
                                )
                            }
                        )
                    }
                }
            }

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Rest of the UI")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { state.show() } }) {
                Text("Click to show sheet")
            }
        }
    }
}

@Composable
fun MainContent() {
    var sheet by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Button(onClick = {
            sheet = true
        }) {
            Text(text = "Click Me")
        }
        if (sheet) {
            AnimatedVisibility(
                true,
                modifier = Modifier.fillMaxSize(),
                enter = slideInHorizontally(
                    initialOffsetX = { -300 }, // small slide 300px
                    animationSpec = tween(
                        durationMillis = 3000,
                        easing = LinearEasing // interpolator
                    )
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 3000,
                        easing = LinearEasing
                    )
                )
            ) {
                OpenSheet() {
                    sheet = false
                }
            }
        }
    }
}

@Composable
fun OpenSheet(
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick.invoke()
            },
        shape = RoundedCornerShape(size = 20.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
            Text(
                modifier = Modifier.padding(all = 20.dp),
                text = "Vikas Suthar"
            )
        }
    }
}