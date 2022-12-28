package com.miu.mdp.domain.dto

data class QuizDTO(
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