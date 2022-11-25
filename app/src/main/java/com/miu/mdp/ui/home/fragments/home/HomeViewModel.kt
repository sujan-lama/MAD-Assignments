package com.miu.mdp.ui.home.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.HomeDataDTO
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

    private var _homeDataLiveData = MutableLiveData<HomeDataDTO>()
    val homeDataLiveData: LiveData<HomeDataDTO> = _homeDataLiveData


    fun getHomeData(email: String) = viewModelScope.launch(Dispatchers.IO) {
        val homeData = homeRepository.getHomeData(email)
        homeData?.let {
            _homeDataLiveData.postValue(it)
        }
    }


    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }

}