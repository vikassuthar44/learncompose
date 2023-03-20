package com.example.learncompose

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Animal constructor(name: String) {


    init {
        println("In the Animal")
        println(name)
    }


    constructor(name: String, canFly: Boolean) : this(name) {
        println("In secondary constructor")
        println(name)
    }


}

fun main() {
    val a = Animal("Bee",)
    val b = Animal("Bee",true)


    /*val myArray = IntArray(4)

    // Populating the array
    myArray[0] = 3
    myArray[1] = 2
    myArray[2] = 2
    myArray[3] = 3

    print(intarra(myArray,2))*/
}

fun intarra(intarr: IntArray, item: Int): Int {

    val result = newArray(intarr,item)
    for(value in result) {
        print(" $value")
    }
    println()

    return intarr.filter { it != item }.toIntArray().size
}
fun newArray(intarr: IntArray, item: Int) : IntArray {
    return intarr.filter { it != item }.toIntArray()
}
