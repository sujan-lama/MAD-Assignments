package com.miu.mdp.domain.model

data class Contact(
    val phone: String,
    val email: String,
    val linkedIn: String,
    val github: String,
    val pdf: String
) {

    fun getLinkedInUrl(): String {
        return "https://www.linkedin.com/in/$linkedIn"
    }

    fun getGithubUrl(): String {
        return "https://github.com/$github"
    }
}
