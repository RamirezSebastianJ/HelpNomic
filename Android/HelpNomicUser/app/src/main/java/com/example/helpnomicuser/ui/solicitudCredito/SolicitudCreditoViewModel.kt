package com.example.helpnomicuser.ui.solicitudCredito

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SolicitudCreditoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Solcitud De Credito"
    }
    val text: LiveData<String> = _text
}