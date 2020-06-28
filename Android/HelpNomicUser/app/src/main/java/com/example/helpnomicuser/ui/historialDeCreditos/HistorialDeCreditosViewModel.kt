package com.example.helpnomicuser.ui.historialDeCreditos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistorialDeCreditosViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "Historial de Créditos"
    }
    val text: LiveData<String> = _text
}