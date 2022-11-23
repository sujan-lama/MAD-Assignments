package com.miu.mdp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CertificationDTO(
    val id: Int,
    val certificationName: String,
    val image: String,
    val certificationAuthority: String,
    val certificationDate: String,
    val email: String
) : Parcelable