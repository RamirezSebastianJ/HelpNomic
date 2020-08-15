package com.example.helpnomicuser.entidades


public fun Capitalizar(cadena:String): String{
    var salida:String = ""
    for (c in cadena){
        when{
            c.isLowerCase() -> salida += (c.toUpperCase())
            c.isUpperCase() -> salida += c
            else -> salida += c
        }
    }
    return salida
}
