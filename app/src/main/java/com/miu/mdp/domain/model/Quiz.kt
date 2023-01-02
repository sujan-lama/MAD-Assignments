package com.miu.mdp.domain.model

data class Quiz(
    val id: Int,
    val question: String,
    val answer: String,
    val options: List<String>,
    val userAnswer: String? = null
) {
    fun isCorrect(): Boolean {
        return answer == userAnswer
    }
}