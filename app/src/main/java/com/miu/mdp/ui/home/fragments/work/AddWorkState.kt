package com.miu.mdp.ui.home.fragments.work

sealed class AddWorkState {
    object Loading : AddWorkState()
    object Success : AddWorkState()
    data class Error(val message: String) : AddWorkState()
    object Empty : AddWorkState()
}