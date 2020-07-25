package com.example.helpnomicuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonIngresar.setOnClickListener {
            val textCedula: TextView =  findViewById(R.id.textCedula)
            val textPass: TextView = findViewById(R.id.textPass)

            //println( "cedula" + textCedula.text.toString())
            if(textCedula.text.toString() == "" && textPass.text.toString() == ""){
                val toast:Toast = makeText(this,"Por favor! Ingrese sus datos de acceso", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                val cedula:Int? = textCedula.text.toString().toInt()
                val pass:Int? = textPass.text.toString().toInt()
                val menuUser = Intent(this, MenuUsuarioActivity::class.java)
                menuUser.putExtra("Cedula",cedula)
                menuUser.putExtra("Pass", pass)
                startActivity(menuUser)
            }
        }
    }
}