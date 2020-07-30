package com.example.helpnomicuser.ui.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helpnomicuser.MenuUsuarioActivity
import com.example.helpnomicuser.R
import kotlinx.android.synthetic.main.activity_formulario_solicitud_renovacion.*

class FormularioSolicitudRenovacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_solicitud_renovacion)

        btnSolicitar.setOnClickListener{
            Toast.makeText(this, "Su solicitud ha sido enviada, pronto le notificaremos si ha sido aprobada", Toast.LENGTH_LONG).show()
             val menuUser = Intent(this, MenuUsuarioActivity::class.java)
            startActivity(menuUser)
        }
    }

}