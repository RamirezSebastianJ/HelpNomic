package com.example.helpnomicuser.ui.ayudaHelpNomic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R
import com.example.helpnomicuser.ui.creditosActivos.CreditosActivosViewModel


class AyudaHelpNomicFragment : Fragment() {
    private lateinit var ayudaHelpNomicViewModel: AyudaHelpNomicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ayudaHelpNomicViewModel =
            ViewModelProviders.of(this).get(AyudaHelpNomicViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        ayudaHelpNomicViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}