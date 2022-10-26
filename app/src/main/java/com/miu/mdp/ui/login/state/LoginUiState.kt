package com.miu.mdp.ui.login.state

sealed class LoginUiState {
    object Loading : LoginUiState()
    object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    object Empty : LoginUiState()
}