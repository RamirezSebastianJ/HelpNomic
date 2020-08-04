package com.example.helpnomicuser

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

//Response.Listener<JSONObject>, Response.ErrorListener
//son las implementaciones necesarias para trabajar volley y hacer la conexión con los protocolos http

class MainActivity : AppCompatActivity(), Response.Listener<JSONObject>, Response.ErrorListener  {

    var progreso: ProgressDialog? = null

    var request : RequestQueue? = null
        get() {
            if(field == null){
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    var jsonObjectRequest: JsonObjectRequest? = null

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
                cargarWebService()

            }
        }
    }

    //lo referente al volley

    private fun cargarWebService(){

        progreso = ProgressDialog(this)
        progreso!!.setTitle("Koltin ProgressBar")
        progreso!!.setMessage("Esperes, estamos conectando a la Base de Datos")
        progreso!!.show()


        val url : String = "http://192.168.0.101/HelpNomicUser/loginUsuario.php?cedula=" + textCedula.text.toString() + "&pass=" + textPass.text.toString()
        jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, this, this)
        request?.add(jsonObjectRequest)
    }

    override fun onResponse(response: JSONObject?) {
        Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_LONG).show()
        val cedula:Int? = textCedula.text.toString().toInt()
        val pass:Int? = textPass.text.toString().toInt()
        val menuUser = Intent(this, MenuUsuarioActivity::class.java)
        menuUser.putExtra("Cedula",cedula)
        menuUser.putExtra("Pass", pass)
        startActivity(menuUser)
        textCedula.setText("")
        textPass.setText("")

    }

    override fun onErrorResponse(error: VolleyError?) {
        progreso?.hide()
        Toast.makeText(this, "No se pudo Ingresar", Toast.LENGTH_LONG).show()
        Log.i("Error", error.toString())
    }

}