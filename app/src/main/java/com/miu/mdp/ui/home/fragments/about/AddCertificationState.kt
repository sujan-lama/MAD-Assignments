package com.miu.mdp.ui.home.fragments.about

sealed class AddCertificationState {
    object Loading : AddCertificationState()
    object Success : AddCertificationState()
    data class Error(val message: String) : AddCertificationState()
    object Empty : AddCertificationState()
}