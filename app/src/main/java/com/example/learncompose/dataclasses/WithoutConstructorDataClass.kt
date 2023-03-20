package com.example.learncompose.dataclasses

fun main() {
    val obj = KotlinClasses("Vikas")
    val obj2 = KotlinClasses("Vikas Suthar", false)
}

class KotlinClasses constructor(
    name: String
) {
    init {
        println(name)
    }
    constructor(fullName:String, canFly:Boolean): this(fullName) {
        println("Secondary constructor")
    }
}