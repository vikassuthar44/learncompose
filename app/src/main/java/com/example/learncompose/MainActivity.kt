package com.example.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.customprogress.ProgressIndicator
import com.example.learncompose.ui.theme.LearnComposeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ProgressIndicator(
                        modifier = Modifier.size(80.dp)
                    )
                }

            }
        }
    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch {
            flow {
                (0..10).forEach {
                    emit(it)
                }
            }.map {
                it*it
            }.collect {
                println("value $it")
            }
        }

    }

}

@Composable
fun MainContent() {
    val valueItem = remember {
        mutableStateOf("vikas")
    }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Log.d("Composition", "MainContent: compose Box")
        Column {
            Column(modifier = Modifier.wrapContentSize()) {
                Log.d("Composition", "MainContent: compose Column")
                //Text(text = valueItem.value)
                Log.d("Composition", "MainContent: compose Text")
                TextField(value = valueItem.value, onValueChange = {
                    valueItem.value = it
                })
                Log.d("Composition", "MainContent: compose TextField")
            }
            Text(text = valueItem.value)
        }

    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }
    var expanded1 by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(20.dp)
                .clickable {
                    expanded = !expanded
                }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text("Text which is showing all the time")
            Spacer(modifier.height(20.dp))
            if (expanded) {
                Text("Some text to show or hide with animation as the column is clicked")
            }
        }
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(20.dp)
                .clickable {
                    expanded1 = !expanded1
                }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
        ) {
            Text("Text which is showing all the time without animation")
            Spacer(modifier.height(20.dp))
            if (expanded1) {
                Text("Some text to show or hide with animation as the column is clicked")
            }
        }
        Text("Some text to show or hide with animation as the column is clicked")
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {
        Greeting()
    }
}