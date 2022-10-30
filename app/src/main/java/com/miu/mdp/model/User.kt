package com.miu.mdp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
) : Parcelable
