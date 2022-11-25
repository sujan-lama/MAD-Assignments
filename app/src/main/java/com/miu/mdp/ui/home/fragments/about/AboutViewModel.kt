package com.miu.mdp.ui.home.fragments.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.AboutDTO
import com.miu.mdp.domain.model.CertificationDTO
import com.miu.mdp.domain.model.EducationDTO
import com.miu.mdp.domain.repository.AboutRepository
import com.miu.mdp.domain.repository.CertificationRepository
import com.miu.mdp.domain.repository.EducationRepository
import com.miu.mdp.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

    private val _addEducationStateLiveData = SingleLiveData<AddEducationState>()
    val addEducationState: SingleLiveData<AddEducationState> = _addEducationStateLiveData

    private val _addCertificationStateLiveData = SingleLiveData<AddCertificationState>()
    val addCertificationLiveData: SingleLiveData<AddCertificationState> =
        _addCertificationStateLiveData


    fun getAboutData(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val aboutDataList = aboutRepository.getAboutData(email)
            aboutDataList?.let {
                _aboutDTO.postValue(it)
            }
        }
    }

    fun addEducation(educationDTO: EducationDTO) = viewModelScope.launch(Dispatchers.IO) {
        _addEducationStateLiveData.postValue(AddEducationState.Loading)
        try {
            // simulate 1 second delay
            delay(1000)
            educationRepository.insertEducation(educationDTO)
            _addEducationStateLiveData.postValue(AddEducationState.Success)
        } catch (e: Exception) {
            _addEducationStateLiveData.postValue(AddEducationState.Error(e.message ?: "Error"))
        }
    }

    fun addCertification(certificationDTO: CertificationDTO) =
        viewModelScope.launch(Dispatchers.IO) {

            _addCertificationStateLiveData.postValue(AddCertificationState.Loading)
            try {
                // simulate 1 second delay
                delay(1000)
                certificationRepository.insertCertification(certificationDTO)
                _addCertificationStateLiveData.postValue(AddCertificationState.Success)
            } catch (e: Exception) {
                _addCertificationStateLiveData.postValue(
                    AddCertificationState.Error(
                        e.message ?: "Error"
                    )
                )
            }
        }

    fun deleteEducation(educationDTO: EducationDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            educationRepository.deleteEducation(educationDTO)
            getAboutData(educationDTO.email)
        }
    }

    fun deleteCertification(certificationDTO: CertificationDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            certificationRepository.deleteCertification(certificationDTO)
            getAboutData(certificationDTO.email)
        }
    }
}