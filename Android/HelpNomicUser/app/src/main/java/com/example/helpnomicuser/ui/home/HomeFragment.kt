package com.example.helpnomicuser.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.helpnomicuser.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        var prefs: SharedPreferences = requireActivity().getSharedPreferences("Preferences", 0)
        var nombre: String? = prefs.getString("nombre", "")

        val nombre_home: EditText = root.findViewById(R.id.textInputUsuario)
        nombre_home.setText(nombre)

        return root
    }
}