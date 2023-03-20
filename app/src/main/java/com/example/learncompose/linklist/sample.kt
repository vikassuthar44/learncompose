package com.example.learncompose.linklist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

fun main() {
    val array1:Array<Any> = arrayOf("goat", "fish", "deer", "bear")
    val array2:Array<Any> = arrayOf("fadd","ant", "bear", "goat", "goat")
    val array3:Array<Any> = arrayOf(1,5,6,7,4,3,2)
    val array4:Array<Any> = arrayOf(5,6,8,23,6)
    //array3.sort()
    array3.map {
        //print(it)
    }

    solve(array3, array4).map {
        println(it)
    }
}

fun solve(array1: Array<Any>, array2: Array<Any>): Array<Any> {
    val mutableArr1 = array1.toMutableList()
    val result = mutableListOf<Any>()
        array2.map {
        if(!mutableArr1.contains(it)) {
            result.add(it)
        } else {
            mutableArr1.remove(it)
        }
    }
    val resultedArr = mutableListOf<Any>()
    if(result.size > 0) {
        val isInt = result[0]
        if(isInt is Int) {
            result.toTypedArray().sort()
            result.map {
                resultedArr.add(it)
            }
        } else {
            result.toTypedArray().sortedBy {
                it.toString()
            }
            result.map {
                resultedArr.add(it)
            }
        }
    }
    return resultedArr.toTypedArray()
}

@Composable
fun Content() {
    LifeCycleEventEffect(
        onResume = {
        },

        onPause = {
        }
    )
}
@Composable
fun LifeCycleEventEffect(
    onCreate: () -> Unit = {},
    onStart: () -> Unit = {},
    onResume: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    onDestroy: () -> Unit = {},
) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val observer = remember {
        LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_CREATE -> onCreate()
                Lifecycle.Event.ON_START -> onStart()
                Lifecycle.Event.ON_RESUME -> onResume()
                Lifecycle.Event.ON_PAUSE -> onPause()
                Lifecycle.Event.ON_STOP -> onStop()
                Lifecycle.Event.ON_DESTROY -> onDestroy()
                Lifecycle.Event.ON_ANY -> { }
            }
        }
    }

    DisposableEffect(key1 = true) {
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}