package com.example.helpnomicuser.ui.formularios

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helpnomicuser.R
import kotlinx.android.synthetic.main.activity_formulario_solicitud_credito.*
import java.util.*

class FormularioSolicitudCreditoActivity : AppCompatActivity() {

    var dia: Int? = null
    var mes: Int? = null
    var ano: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_solicitud_credito)

        //Capturar Fecha por medio de un calendario
        btnFecha.setOnClickListener{
            val c: Calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                Toast.makeText(this, "Year : " + year
                + "\nMonth : " + month
                + "\nDate : " + dayOfMonth, Toast.LENGTH_SHORT).show()
            },
                c.get(Calendar.YEAR ), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
            datePickerDialog.show()
        }

        //Capturar el boton para solicitar el credito
        btnSolicitar.setOnClickListener{
            val confirmacionSC = Intent(this, ConfirmacionSolicitudCredito::class.java)
            startActivity(confirmacionSC)
        }
    }
}