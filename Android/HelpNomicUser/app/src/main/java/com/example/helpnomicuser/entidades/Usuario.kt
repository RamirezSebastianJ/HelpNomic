package com.example.helpnomicuser.entidades

import java.io.Serializable

class Usuario: Serializable {
    var nombre: String? = null
    var cedula: String? = null
    var direccion: String? = null
    var cantidad_prestamos: String? =null
    var puntos_negativos: String? =null
    var telefono: String? = null
    var deuda_total: String? = null
    var id_admnistrador: String? = null
}