package com.miu.mdp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val phone: String,
    val email: String,
    val linkedIn: String,
    val github: String,
    val pdf: String
) : Parcelable {

    fun getLinkedInUrl(): String {
        if (linkedIn == "N/A") return linkedIn
        if (linkedIn.startsWith("https://www.linkedin.com/in/")) {
            return linkedIn
        }
        return "https://www.linkedin.com/in/$linkedIn"
    }

    fun getGithubUrl(): String {
        if (github == "N/A") return github
        if (github.startsWith("https://github.com/")) {
            return github
        }
        return "https://github.com/$github"
    }
}
