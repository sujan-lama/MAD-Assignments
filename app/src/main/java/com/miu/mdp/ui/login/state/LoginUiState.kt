package com.miu.mdp.ui.login.state

import com.miu.mdp.domain.model.User

sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Success(val user: User) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    object Empty : LoginUiState()
}