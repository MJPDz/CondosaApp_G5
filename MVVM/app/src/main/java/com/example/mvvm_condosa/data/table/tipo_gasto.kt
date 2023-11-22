package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object TipoGastoTable : IntIdTable("tipo_gasto", "id_tipo_gasto") {
    val id_clase_gasto = integer("id_clase_gasto").index()
    val descripcion = varchar("descripcion", length = 50)
}