package com.example.learncompose.linklist

fun main() {

    val list = LinkedList<Int>()
    list.push(1)
    list.push(4)
    list.push(10)
    println(list)
    val intArray = intArrayOf(1,23,4,5,6,4)
    intArray.toSet()
    System.currentTimeMillis()
    val hashest = hashSetOf<Int>()
    println(hashest.add(2))
    println(hashest.add(2))

    Int.MIN_VALUE

}