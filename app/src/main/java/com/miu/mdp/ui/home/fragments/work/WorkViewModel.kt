package com.miu.mdp.ui.home.fragments.work

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val addWorkStateLiveData = MutableLiveData<AddWorkState>(AddWorkState.Empty)
    val addWorkState: LiveData<AddWorkState> = addWorkStateLiveData

    fun addWorkExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        addWorkStateLiveData.postValue(AddWorkState.Loading)
        try {
            // simulate 1 second delay
            delay(1000)
            repository.addWorkExperience(experience)
            addWorkStateLiveData.postValue(AddWorkState.Success)
        } catch (e: Exception) {
            addWorkStateLiveData.postValue(AddWorkState.Error(e.message ?: "Error"))
        }
    }

}