package com.miu.mdp.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.UserDataDTO
import com.miu.mdp.domain.repository.HomeRepository
import com.miu.mdp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private var _userDataDTO = MutableLiveData<UserDataDTO>()
    val userDataDTO: LiveData<UserDataDTO> = _userDataDTO

    init {
        getUserData()
    }

    fun getUserData() = viewModelScope.launch(Dispatchers.IO) {
        val userDetail = homeRepository.getUserWithData()
        userDetail?.let {
            _userDataDTO.postValue(it)
        }
    }


    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }

}