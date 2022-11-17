package com.miu.mdp.ui.start.state

sealed class StartUiState {
    object Empty : StartUiState()
    data class LoggedIn(val email: String) : StartUiState()
    object LoggedOut : StartUiState()
}