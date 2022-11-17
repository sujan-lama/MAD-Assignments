package com.miu.mdp.ui.home.fragments.work

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.Experience
import com.miu.mdp.domain.repository.ExperienceRepository
import com.miu.mdp.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor(
    private val experienceRepository: ExperienceRepository
) : ViewModel() {

    private val _workExperienceLiveData =
        MutableLiveData<List<Experience>>(listOf())
    val workExperienceLiveData: LiveData<List<Experience>> = _workExperienceLiveData

    private val _addWorkStateLiveData = SingleLiveData<AddWorkState>()
    val addWorkState: SingleLiveData<AddWorkState> = _addWorkStateLiveData

    fun getWorkExperience(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val workExperienceList = experienceRepository.getExperience(email)
            _workExperienceLiveData.postValue(workExperienceList)
        }
    }

    fun addWorkExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        _addWorkStateLiveData.postValue(AddWorkState.Loading)
        try {
            // simulate 1 second delay
            delay(1000)
            experienceRepository.addWorkExperience(experience)
            _addWorkStateLiveData.postValue(AddWorkState.Success)
        } catch (e: Exception) {
            _addWorkStateLiveData.postValue(AddWorkState.Error(e.message ?: "Error"))
        }
    }

    fun removeWorkExperience(experience: Experience) = viewModelScope.launch(Dispatchers.IO) {
        experienceRepository.deleteExperience(experience)
        getWorkExperience(email = experience.email)
    }

}