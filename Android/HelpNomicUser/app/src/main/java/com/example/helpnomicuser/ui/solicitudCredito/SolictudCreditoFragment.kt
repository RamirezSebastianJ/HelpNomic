package com.example.helpnomicuser.ui.solicitudCredito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R

class SolictudCreditoFragment : Fragment() {

    private lateinit var solicitudCreditoViewModel: SolicitudCreditoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        solicitudCreditoViewModel =
            ViewModelProviders.of(this).get(SolicitudCreditoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_solicitud_credito, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_gallery)
        solicitudCreditoViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}