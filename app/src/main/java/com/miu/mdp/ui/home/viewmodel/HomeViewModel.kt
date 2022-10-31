package com.miu.mdp.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.User
import com.miu.mdp.domain.model.UserDetail
import com.miu.mdp.domain.repository.HomeRepository
import com.miu.mdp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val homeRepository: HomeRepository
) : ViewModel() {

    private var _userDetail = MutableLiveData<UserDetail>()
    val userDetail: LiveData<UserDetail> = _userDetail

    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        getUserDetails()
    }

    private fun getUserDetails() = viewModelScope.launch(Dispatchers.IO) {
        val userDetail = homeRepository.getUserDetail()
        val user = homeRepository.getUser()
        userDetail?.let {
            _userDetail.postValue(it)
        }
        user?.let {
            _user.postValue(it)
        }
    }

    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }

}