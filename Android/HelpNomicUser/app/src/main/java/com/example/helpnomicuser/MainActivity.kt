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
import com.example.helpnomicuser.entidades.Capitalizar
import com.example.helpnomicuser.entidades.Usuario
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

//Response.Listener<JSONObject>, Response.ErrorListener
//son las implementaciones necesarias para trabajar volley y hacer la conexión con los protocolos http

class MainActivity : AppCompatActivity(), Response.Listener<JSONObject>, Response.ErrorListener  {

    var textCedula: TextView? =  null
    var textPass: TextView? = null

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
            textCedula = findViewById(R.id.textCedula)
            textPass = findViewById(R.id.textPass)
            if(textCedula?.text.toString() == "" && textPass?.text.toString() == ""){
                val toast:Toast = makeText(this,"Por favor! Ingrese sus datos de acceso", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                cargarWebService()
            }
        }
    }

    //lo referente al volley

    private fun cargarWebService(){

        //Barrra de Carga
        progreso = ProgressDialog(this)
        progreso!!.setTitle("Koltin ProgressBar")
        progreso!!.setMessage("Espere, estamos conectando la Base de Datos")
        progreso!!.show()


        val url : String = "http://192.168.0.104/HelpNomicUser/loginUsuario.php?cedula=" + textCedula?.text.toString() + "&pass=" + textPass?.text.toString()
        jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, this, this)
        request?.add(jsonObjectRequest)

    }

    override fun onResponse(response: JSONObject?) {
        Toast.makeText(this, "BIENVENIDO a HELPNOMIC", Toast.LENGTH_LONG).show()

        var miUsuario: Usuario = Usuario()

        val json: JSONArray? = response?.optJSONArray("usuario")
        var jsonObject: JSONObject? = null

        try {
            jsonObject = json?.getJSONObject(0)
            miUsuario.nombre = jsonObject?.optString("nombre")
            miUsuario.nombre = miUsuario.nombre?.let { Capitalizar(it) }
            miUsuario.cedula = jsonObject?.optString("cedula")
            miUsuario.direccion = jsonObject?.optString("direccion")
            miUsuario.cantidad_prestamos = jsonObject?.optString("cantidad_prestamos")
            miUsuario.puntos_negativos = jsonObject?.optString("puntos_negativos")
            miUsuario.telefono = jsonObject?.optString("telefono")
            miUsuario.deuda_total = jsonObject?.optString("deuda_total")
            miUsuario.id_admnistrador = jsonObject?.optString("id_administrador")

        }catch (e: JSONException){
            e.printStackTrace()
        }

        val cedula:Int? = textCedula?.text.toString().toInt()
        val nombre:String? = miUsuario.nombre

        val menuUser = Intent(this, MenuUsuarioActivity::class.java)
        menuUser.putExtra("MiUsuario", miUsuario)

        startActivity(menuUser)

    }

    override fun onErrorResponse(error: VolleyError?) {
        progreso?.hide()
        Toast.makeText(this, "No se pudo Ingresar", Toast.LENGTH_LONG).show()
        Log.i("Error", error.toString())
    }

}