package com.example.learncompose.lol

fun main() {
    guide()
}


fun guide() {
    println("guide start")
    teach()
    println("guide end")
}

inline fun teach() {
    println("teach")
}