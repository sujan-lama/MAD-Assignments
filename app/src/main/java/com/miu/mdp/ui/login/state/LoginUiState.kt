package com.miu.mdp.ui.login.state

import com.miu.mdp.domain.model.UserDTO

sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Success(val userDTO: UserDTO) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    object Empty : LoginUiState()
}