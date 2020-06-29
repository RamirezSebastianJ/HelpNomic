package com.example.helpnomicuser.ui.historialDeCreditos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R


class HistorialDeCreditosFragment : Fragment() {
    private lateinit var historialDeCreditosViewModel: HistorialDeCreditosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historialDeCreditosViewModel =
            ViewModelProviders.of(this).get(HistorialDeCreditosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_historial_de_creditos, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        historialDeCreditosViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}