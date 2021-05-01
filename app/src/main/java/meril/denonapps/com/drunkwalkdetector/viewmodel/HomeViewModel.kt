package meril.denonapps.com.drunkwalkdetector.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shoo.denonapps.com.ocbanking.ui.base.events.SingleLiveEvent
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    private val _saveContact = SingleLiveEvent<Unit>()
    val saveContact: LiveData<Unit>
        get() = _saveContact

    private val _removeContact = SingleLiveEvent<Unit>()
    val removeContact: LiveData<Unit>
        get() = _removeContact

    val contactNumber = MutableLiveData("")

    fun saveContactPressed() {
        _saveContact.call()
    }

    fun removeContactPressed() {
        _removeContact.call()
    }

    fun setContactNumber(number: String) {
        contactNumber.value = number
    }



}