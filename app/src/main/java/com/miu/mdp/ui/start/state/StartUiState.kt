package com.miu.mdp.ui.start.state

sealed class StartUiState {
    object Empty : StartUiState()
    object LoggedIn : StartUiState()
    object LoggedOut : StartUiState()
}