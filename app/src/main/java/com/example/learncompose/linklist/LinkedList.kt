package com.example.learncompose.linklist

import java.util.Stack

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    private fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if(isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun push(value: T) {
        head = Node(value = value, next = head)
        if(tail == null) {
            tail = head
        }
        size++
    }
    val stack = Stack<Int>()

}

