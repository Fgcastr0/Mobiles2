package com.example.parcial1mobile2

data class Champion(
    val id: Int,
    val nombre: String,
    val imagen: String?,
    val tipo: TipoCampeon,
    val rol: String,
    val clase: String
) {

}

enum class TipoCampeon { MAGO, LUCHADOR, TIRADOR, TANQUE, SOPORTE, ASESINO }

