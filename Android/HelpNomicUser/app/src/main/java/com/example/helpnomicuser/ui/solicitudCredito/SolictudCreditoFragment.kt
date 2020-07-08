package com.example.helpnomicuser.ui.solicitudCredito

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.ui.formularios.FormularioSolicitudCreditoActivity
import com.example.helpnomicuser.OnFragmentActionListener
import com.example.helpnomicuser.R


class SolictudCreditoFragment : Fragment() {

    private lateinit var solicitudCreditoViewModel: SolicitudCreditoViewModel

    private var listener: OnFragmentActionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        solicitudCreditoViewModel = ViewModelProviders.of(this).get(SolicitudCreditoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_solicitud_credito, container, false)
        val btnVerificar: Button = root.findViewById(R.id.buttonVerificar)

        /*
        *Lanzar la Actividad del Formulario
         */
        val formulario: Intent = Intent(activity, FormularioSolicitudCreditoActivity::class.java)
        btnVerificar.setOnClickListener{
            listener?.onClickFragmentButton()
            startActivity(formulario)
        }
        /*====================================*/
        
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnFragmentActionListener){
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}