package com.example.helpnomicuser.ui.creditosActivos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreditosActivosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Créditos Activos"
    }
    val text: LiveData<String> = _text
}