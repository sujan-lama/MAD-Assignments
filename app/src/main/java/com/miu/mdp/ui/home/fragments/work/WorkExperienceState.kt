package com.miu.mdp.ui.home.fragments.work

import com.miu.mdp.domain.model.Experience

sealed class WorkExperienceState {
    object Loading : WorkExperienceState()
    data class Success(val data: List<Experience>) : WorkExperienceState()
    data class Error(val message: String) : WorkExperienceState()
}