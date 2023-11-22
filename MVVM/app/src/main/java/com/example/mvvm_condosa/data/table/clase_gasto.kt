package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object ClaseGastoTable : IntIdTable("clase_gasto", "id_clase_gasto") {
    val descripcion = varchar("descripcion", length = 30)
}