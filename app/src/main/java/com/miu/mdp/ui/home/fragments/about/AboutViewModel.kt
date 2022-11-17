package com.miu.mdp.ui.home.fragments.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.AboutDTO
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.model.Education
import com.miu.mdp.domain.repository.AboutRepository
import com.miu.mdp.domain.repository.CertificationRepository
import com.miu.mdp.domain.repository.EducationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private val aboutRepository: AboutRepository,
    private val educationRepository: EducationRepository,
    private val certificationRepository: CertificationRepository
) : ViewModel() {

    private val _aboutDTO = MutableLiveData<AboutDTO>()
    val aboutDTO: LiveData<AboutDTO> = _aboutDTO

    fun getAboutData(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val aboutDataList = aboutRepository.getAboutData(email)
            _aboutDTO.postValue(aboutDataList)
        }
    }

    fun addEducation(education: Education) {
        viewModelScope.launch(Dispatchers.IO) {
            educationRepository.insertEducation(education)
        }
    }

    fun addCertification(certification: Certification) {
        viewModelScope.launch(Dispatchers.IO) {
            certificationRepository.insertCertification(certification)
        }
    }
}