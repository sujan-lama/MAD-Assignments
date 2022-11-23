package com.miu.mdp.ui.home.fragments.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.repository.ContactRepository
import com.miu.mdp.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactRepository: ContactRepository
) : ViewModel() {

    private val _contactLiveData = MutableLiveData<Contact>()
    val contactLiveData: LiveData<Contact> = _contactLiveData

    private val _addContactStateLiveData = SingleLiveData<AddContactState>()
    val addContactState: SingleLiveData<AddContactState> = _addContactStateLiveData

    fun getContact(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val contact = contactRepository.getContact(email)
            _contactLiveData.postValue(contact)
        }
    }

    fun addContact(contact: Contact, email: String) = viewModelScope.launch(Dispatchers.IO) {
        _addContactStateLiveData.postValue(AddContactState.Loading)
        try {
            // simulate 1 second delay
            delay(1000)
            contactRepository.addContact(contact = contact, email = email)
            _addContactStateLiveData.postValue(AddContactState.Success)
        } catch (e: Exception) {
            _addContactStateLiveData.postValue(AddContactState.Error(e.message ?: "Error"))
        }
    }

    fun updateContact(contact: Contact, email: String) = viewModelScope.launch(Dispatchers.IO) {
        _addContactStateLiveData.postValue(AddContactState.Loading)
        try {
            // simulate 1 second delay
            delay(1000)
            contactRepository.updateContact(contact = contact, email = email)
            _addContactStateLiveData.postValue(AddContactState.Success)
        } catch (e: Exception) {
            _addContactStateLiveData.postValue(AddContactState.Error(e.message ?: "Error"))
        }

    }
}
