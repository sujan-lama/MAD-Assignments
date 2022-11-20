package com.miu.mdp.ui.home.fragments.work

import com.miu.mdp.domain.model.ExperienceDTO

sealed class WorkExperienceState {
    object Loading : WorkExperienceState()
    data class Success(val data: List<ExperienceDTO>) : WorkExperienceState()
    data class Error(val message: String) : WorkExperienceState()
}