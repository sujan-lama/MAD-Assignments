package com.miu.mdp.ui.home.fragments.contact

sealed class AddContactState {
    object Loading : AddContactState()
    object Success : AddContactState()
    data class Error(val message: String) : AddContactState()
    object Empty : AddContactState()
}