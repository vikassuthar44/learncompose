package com.example.learncompose.quiz

class Quiz {
    val question1 = Question("Country Name?", "India", Difficulty.ESAY)
    val question2 = Question("Country Name?", true, Difficulty.MEDIUM)
    val question3 = Question("Country Name?", 3, Difficulty.MEDIUM)

    companion object StudentProgress {
        val total: Int = 10
        val answered: Int = 3
    }
}
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    println("Total Questions ${Quiz.StudentProgress.total} and answered ${Quiz.StudentProgress.answered}")
}

enum class Difficulty {
    ESAY, MEDIUM, HARD
}