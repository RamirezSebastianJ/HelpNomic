package com.example.helpnomicuser

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.helpnomicuser.entidades.Usuario


class MenuUsuarioActivity : AppCompatActivity(), OnFragmentActionListener,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        var prefs: SharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = prefs.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_usuario)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Recibir datos del main activity
        val bundle = intent.extras
        val miUsuario: Usuario = bundle?.getSerializable("MiUsuario") as Usuario

        editor.putString("nombre", miUsuario.nombre.toString())
        editor.putString("cedula", miUsuario.cedula.toString())
        editor.putString("montoPrestado", miUsuario.deuda_total.toString())
        editor.putString("puntosNegros", miUsuario.puntos_negativos.toString())
        editor.commit()

        //Bundle con el que se pasaran los datos del usuario al fragment Home
        val bundleFragment: Bundle = Bundle()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
            navigationView.setNavigationItemSelectedListener(this)

        val hview: View = navigationView.getHeaderView(0)
        val nombre_nav:TextView = hview.findViewById(R.id.nombre_nav_user)
        val cc:TextView = hview.findViewById(R.id.cedula_nav_user)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)


        //Cambio de nombre y cedula del usuario en los campos de la cabecera del navigation Drawer
        nombre_nav.setText(miUsuario.nombre)
        cc.setText(miUsuario.cedula.toString())

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_creditosActivosFragment,
                R.id.nav_historialDeCreditosFragment, R.id.nav_ayudaHelpNomicFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_usuario, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //Por el momento es obligatorio implementar este metodo  porque de lo contrario no se implementar la interpretación de los botonos
    override fun onClickFragmentButton() {
        print("Boton pulsado")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }


}