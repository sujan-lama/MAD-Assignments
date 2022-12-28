package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.Quiz
import com.miu.mdp.domain.dto.QuizDTO

fun Quiz.toDTO() = QuizDTO(
    id = id,
    question = question,
    answer = answer,
    options = options,
    userAnswer = userAnswer
)

fun QuizDTO.toEntity() = Quiz(
    id = id,
    question = question,
    answer = answer,
    options = options,
    userAnswer = userAnswer
)