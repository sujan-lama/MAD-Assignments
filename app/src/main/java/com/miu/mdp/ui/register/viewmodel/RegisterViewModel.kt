package com.miu.mdp.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.model.User
import com.miu.mdp.repository.user.UserRepository
import com.miu.mdp.ui.register.state.RegisterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _registerUiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Empty)
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState

    fun register(firstName: String, lastName: String, username: String, password: String) =
        viewModelScope.launch {
            _registerUiState.value = RegisterUiState.Loading
            delay(2000L)
            val user = User(firstName, lastName, username, password)
            val success = userRepository.register(user)
            if (success) {
                _registerUiState.value = RegisterUiState.Success
            } else {
                _registerUiState.value = RegisterUiState.Error("Email already exists")
            }
        }
}