package com.miu.mdp.ui.home.fragments.about

sealed class AddEducationState {
    object Loading : AddEducationState()
    object Success : AddEducationState()
    data class Error(val message: String) : AddEducationState()
    object Empty : AddEducationState()
}