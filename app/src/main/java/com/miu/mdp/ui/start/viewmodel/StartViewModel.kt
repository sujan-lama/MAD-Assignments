package com.miu.mdp.ui.start.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.repository.UserRepository
import com.miu.mdp.ui.start.state.StartUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _startUiState = MutableStateFlow<StartUiState>(StartUiState.Empty)
    val startUiState: StateFlow<StartUiState> = _startUiState

    fun checkLogin() = viewModelScope.launch {
        val user = userRepository.getUser()
        if (user != null) {
            _startUiState.value = StartUiState.LoggedIn(user.username)
        } else {
            _startUiState.value = StartUiState.LoggedOut
        }
    }

}