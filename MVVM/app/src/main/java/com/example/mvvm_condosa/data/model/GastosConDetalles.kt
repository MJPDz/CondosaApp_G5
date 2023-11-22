package com.example.mvvm_condosa.data.model

data class GastosConDetalles(
    val idPredioGastosDet: Int,
    val idPredioGastos: Int,
    val idGasto: Int,
    val importe: Double?,
    val idTipoGasto: Int,
    val descripcion: String?,
    val periodo: String?,
    val idPersonal: Int?,
    val idPersona: Int?,
    val nombres: String?,
    val predio: String?
)
