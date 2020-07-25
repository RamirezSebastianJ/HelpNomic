package com.example.helpnomicuser.ui.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helpnomicuser.MenuUsuarioActivity
import com.example.helpnomicuser.R
import kotlinx.android.synthetic.main.activity_confirmacion_solicitud_credito.*

class ConfirmacionSolicitudCredito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion_solicitud_credito)

        btnConfirmar.setOnClickListener{
            Toast.makeText(this, "Su solictud ha sido realizada, pronto recibiirá una respuesta", Toast.LENGTH_LONG).show()
            val menuUseer = Intent(this, MenuUsuarioActivity::class.java)
            startActivity(menuUseer)
        }
    }
}