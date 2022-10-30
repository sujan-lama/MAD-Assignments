package com.miu.mdp.ui.register.state

sealed class RegisterUiState {
    object Loading : RegisterUiState()
    object Success : RegisterUiState()
    data class Error(val message: String) : RegisterUiState()
    object Empty : RegisterUiState()
}