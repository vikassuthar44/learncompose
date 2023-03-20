package com.example.learncompose.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.learncompose.R
import kotlinx.coroutines.*
import kotlin.math.log

class CoroutineClass: AppCompatActivity() {

    companion object {
        const val TAG = "CoroutineClass"
    }
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.life_cycle)
        print("coroutine result")
        val deferred = GlobalScope.async(Dispatchers.Main) {
            return@async 15
        }

        val button = findViewById<Button>(R.id.button)
        button.text = "sadcasdfcadsfadsf"
        coroutineCall()

    }

    private fun coroutineCall() {
        GlobalScope.launch(Dispatchers.Main) {
            val result1 = async {  taskOne() }
            val result2 = async {  taskTwo() }
            val result = result1.await() + result2.await()
            Log.d(TAG, "coroutineCall: result  $result")
        }
    }

    private suspend fun taskOne() : Int{
        return withContext(Dispatchers.Default) {
            Log.d(TAG, "taskOne: start delay")
            delay(2000)
            Log.d(TAG, "taskOne: after delya")
            return@withContext 10
        }
    }

    private suspend fun taskTwo(): Int {
        return withContext(Dispatchers.Default) {
            Log.d(TAG, "taskTwo: start delay")
            delay(2000)
            Log.d(TAG, "taskTwo: after delay")
            return@withContext 10
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
}