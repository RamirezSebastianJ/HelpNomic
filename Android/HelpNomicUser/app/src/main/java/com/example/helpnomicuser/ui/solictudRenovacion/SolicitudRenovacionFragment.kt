package com.example.helpnomicuser.ui.solictudRenovacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R

class SolicitudRenovacionFragment : Fragment() {

    private lateinit var solicitudRenovacionViewModel: SolicitudRenovacionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        solicitudRenovacionViewModel =
            ViewModelProviders.of(this).get(SolicitudRenovacionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_solicitud_renovacion, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        solicitudRenovacionViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}