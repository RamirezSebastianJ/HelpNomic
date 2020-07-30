package com.example.helpnomicuser.ui.creditosActivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R
import com.example.helpnomicuser.ui.home.HomeViewModel

class CreditosActivosFragment : Fragment() {
    private lateinit var creditosActivosViewModel: CreditosActivosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creditosActivosViewModel =
            ViewModelProviders.of(this).get(CreditosActivosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_creditos_activos, container, false)

        return root
    }
}