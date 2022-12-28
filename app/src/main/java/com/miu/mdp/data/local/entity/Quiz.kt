package com.miu.mdp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val question: String,
    val answer: String,
    val options: List<String>,
    val userAnswer: String? = null
)