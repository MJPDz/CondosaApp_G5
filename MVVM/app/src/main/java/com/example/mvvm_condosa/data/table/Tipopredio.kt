package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object TipoPredioTable : IntIdTable("tipo_predio", "id_tipo_predio") {
    val nombre_predio = varchar("nomre_predio", 255)
}