package com.miu.mdp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDTO(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
) : Parcelable
