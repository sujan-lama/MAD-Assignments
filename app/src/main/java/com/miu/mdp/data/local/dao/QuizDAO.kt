package com.miu.mdp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.miu.mdp.data.local.entity.Quiz

@Dao
interface QuizDAO : BaseDAO<Quiz> {

    @Query("SELECT * FROM Quiz WHERE id = :id")
    suspend fun getQuizById(id: Int): Quiz?

    @Query("SELECT * FROM Quiz")
    suspend fun getQuizList(): List<Quiz>
}