package com.example.helpnomicuser.ui.solictudRenovacion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.OnFragmentActionListener
import com.example.helpnomicuser.R
import com.example.helpnomicuser.ui.formularios.FormularioSolicitudRenovacion

class SolicitudRenovacionFragment : Fragment() {

    private lateinit var solicitudRenovacionViewModel: SolicitudRenovacionViewModel
    private var listener: OnFragmentActionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        solicitudRenovacionViewModel =
            ViewModelProviders.of(this).get(SolicitudRenovacionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_solicitud_renovacion, container, false)
        val btn1: Button = root.findViewById(R.id.btnFecha1)
        val btn2: Button = root.findViewById(R.id.btnFecha2)
        val btn3: Button = root.findViewById(R.id.btnFecha4)

        /*
        *Lanzar la Actividad del Formulario
         */
        val formulario: Intent = Intent(activity, FormularioSolicitudRenovacion::class.java)
        btn1.setOnClickListener{
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