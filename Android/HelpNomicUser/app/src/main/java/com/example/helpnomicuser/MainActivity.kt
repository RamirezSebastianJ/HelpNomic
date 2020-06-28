package com.example.helpnomicuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textCedula: TextView =  findViewById(R.id.textCedula)
        val textPass: TextView = findViewById(R.id.textPass)

        buttonIngresar.setOnClickListener {
            //println( "cedula" + textCedula.text.toString())
            val cedula:Int? = textCedula.text.toString().toInt()
            val pass:Int? = textPass.text.toString().toInt()
            val menuUser = Intent(this, MenuUsuarioActivity::class.java)

            menuUser.putExtra("Cedula",cedula)
            menuUser.putExtra("Pass", pass)

            startActivity(menuUser)
        }
    }

}