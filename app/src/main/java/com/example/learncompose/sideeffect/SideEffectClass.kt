package com.example.learncompose.sideeffect

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.ui.theme.LearnComposeTheme
import com.example.learncompose.utils.Utils

class SideEffectClass : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val startingDataCounter = remember { mutableStateOf(0) }
    val increaseCounterLaunchedEffect = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(0.dp, 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SideEffectContent(
            startingDataCounter = startingDataCounter,
            increaseCounter = increaseCounterLaunchedEffect,
            viewModel = SideEffectViewModel()
        )

    }
}

@Composable
fun SideEffectContent(
    startingDataCounter: MutableState<Int>,
    increaseCounter: MutableState<Int>,
    viewModel: SideEffectViewModel
) {

    var text by remember {
        mutableStateOf("")
    }

    //simple API Call
    //viewModel.getStartingDataFromApi("LaunchEffect")

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getStartingDataFromApi("LaunchEffect")
    })

    val state = viewModel.state.value
    var bgColor = Color.Gray

    //to Observe increasing value changes
    when (state) {
        ResultState.StartingDataCalled -> {
            startingDataCounter.value++
            bgColor = Utils.getRandomColor()
            viewModel.state.value = ResultState.Idle
        }

        ResultState.IncreaseDataCalled -> {
            increaseCounter.value++
            viewModel.state.value = ResultState.Idle
        }

        ResultState.Error -> {

        }
        else -> {

        }
    }

    Text(
        text = "Starting Data Api call count= ${startingDataCounter.value}",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.padding(10.dp))
    Text(
        text = "increase number= ${increaseCounter.value}",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.padding(10.dp))
    LaunchedEffectDemoColumn(viewModel = viewModel, bgColor = bgColor)
    Spacer(modifier = Modifier.padding(10.dp))
}

@Composable
fun LaunchedEffectDemoColumn(
    viewModel: SideEffectViewModel,
    bgColor: Color
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
            .background(bgColor)
            .padding(4.dp)
    ) {
        Text(text = "With LaunchEffect", color = Color.White)
        Spacer(modifier = Modifier.padding(all = 10.dp))
        IncreaseNumberApiButton {
            viewModel.increaseCount("LaunchedEffect")
        }
    }
}

@Composable
fun IncreaseNumberApiButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        onClick = onClick
    ) {
        Text(
            text = "Increase Number Api",
            textAlign = TextAlign.Center
        )
    }
}