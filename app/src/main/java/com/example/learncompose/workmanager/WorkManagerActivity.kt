package com.example.learncompose.workmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class WorkManagerActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainContent()
        }
    }
}


@Composable
fun MainContent() {
    val context = LocalContext.current
    val request = OneTimeWorkRequestBuilder<MyWork>().build()
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            WorkManager.getInstance(context).enqueue(request)
        }) {
            Text(text = "Send Notifications")
        }

    }
}