package com.miu.mdp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExperienceDTO(
    val id: Int,
    val companyName: String,
    val image: String,
    val position: String,
    val startDate: String,
    val endDate: String,
    val description: String,
    val email: String
) : Parcelable