package com.miu.mdp.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.repository.user.UserRepository
import com.miu.mdp.ui.login.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState


    fun login(username: String, password: String) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        delay(2000L)
        val success = userRepository.login(username, password)
        if (success) {
            _loginUiState.value = LoginUiState.Success
        } else {
            _loginUiState.value = LoginUiState.Error("Invalid username or password")
        }
    }

}
