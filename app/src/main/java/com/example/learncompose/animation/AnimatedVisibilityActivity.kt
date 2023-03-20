package com.example.learncompose.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learncompose.animation.fab.FabScreen
import com.example.learncompose.ui.theme.LearnComposeTheme

class AnimatedVisibilityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearnComposeTheme {
                FabScreen()
            }
        }
    }
}

