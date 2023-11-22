package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object GastoTable : IntIdTable("gasto", "id_gasto") {
    val id_tipo_gasto = integer("id_tipo_gasto").index()
    val descripcion = varchar("descripcion", length = 100)
}