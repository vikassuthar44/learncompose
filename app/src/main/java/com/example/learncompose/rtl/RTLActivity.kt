package com.example.learncompose.rtl

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.WelcomeScreen

class RTLActivity: ComponentActivity() {

    companion object {
        const val TAG = "VIKASSUTHAR"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WelcomeScreen()
            /*Row(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val initValue = ""
                val behaviour = CursorSelectionBehaviour.START
                val direction = LocalLayoutDirection.current

                var tfv = remember {
                    mutableStateOf(
                        TextFieldValue(
                            text = "",
                            selection = TextRange(0)
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                        BasicTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Blue),
                            value = tfv.value,
                            onValueChange = {

                            },
                            textStyle = TextStyle(textAlign = TextAlign.Start, fontSize = 32.sp, textDirection = TextDirection.Rtl)
                        )


                }
            }*/
        }
    }
}

enum class CursorSelectionBehaviour {
    START, END, SELECT_ALL
}
