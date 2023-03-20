package com.example.learncompose.otp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learncompose.ui.theme.LearnComposeTheme

class OtpScreenActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                OtpScreenContent()
            }
        }

    }


    fun printTwoNumber(a: Int, b: Int): Int {
        //val sum = a + b
        val sum = add(a, b)
        return sum
    }

     fun add(a: Int, b: Int): Int {
        return  a + b
    }

}