package com.example.learncompose.linklist

data class Node<T>(val value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if(next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}

data class DoublyNode<T>(val value: T, var next: DoublyNode<T>?, var previous: DoublyNode<T>?) {
    override fun toString(): String {
        return if(next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }
}