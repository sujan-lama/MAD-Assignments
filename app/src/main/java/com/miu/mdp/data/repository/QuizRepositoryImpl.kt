package com.miu.mdp.data.repository

import com.miu.mdp.data.local.AppDatabase
import com.miu.mdp.data.local.dao.QuizDAO
import com.miu.mdp.data.mapper.toDTO
import com.miu.mdp.data.mapper.toEntity
import com.miu.mdp.domain.dto.QuizDTO
import com.miu.mdp.domain.repository.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val quizDAO: QuizDAO
) :QuizRepository {
    override suspend fun getQuizById(id: Int): QuizDTO? {
        return quizDAO.getQuizById(id)?.toDTO()
    }

    override suspend fun getQuizList(): List<QuizDTO> {
        return quizDAO.getQuizList().map { it.toDTO() }
    }

    override suspend fun saveQuiz(quiz: QuizDTO) {
        quizDAO.insert(quiz.toEntity())
    }
}