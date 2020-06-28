package com.example.helpnomicuser.ui.solictudRenovacion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SolicitudRenovacionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Solicitud de Renovación"
    }
    val text: LiveData<String> = _text
}