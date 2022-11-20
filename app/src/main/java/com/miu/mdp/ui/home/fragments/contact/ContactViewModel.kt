package com.miu.mdp.ui.home.fragments.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : ViewModel() {

    private val _contactLiveData = MutableLiveData<Contact>()
    val contactLiveData: LiveData<Contact> = _contactLiveData

    fun getContact(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val contact = contactRepository.getContact(email)
            _contactLiveData.postValue(contact)
        }
    }
}
