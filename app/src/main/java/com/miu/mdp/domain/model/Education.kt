package com.miu.mdp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Education(
    val id: Int,
    val schoolName: String,
    val image: String,
    val degree: String,
    val startDate: String,
    val endDate: String,
    val email: String
) : Parcelable