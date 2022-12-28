package com.miu.mdp.domain.repository

import com.miu.mdp.domain.dto.QuizDTO

interface QuizRepository {
    suspend fun getQuizById(id: Int): QuizDTO?
    suspend fun getQuizList(): List<QuizDTO>
    suspend fun saveQuiz(quiz: QuizDTO)
}