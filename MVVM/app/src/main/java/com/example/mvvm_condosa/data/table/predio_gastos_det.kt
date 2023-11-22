package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object GastosDetTable : IntIdTable("predio_gastos_det", "id_predio_gastos_det") {
    val id_predio_gastos = integer("id_predio_gastos").references(GastosTable.id)
    val id_gasto = integer("id_gasto").references(GastoTable.id)
    val importe = double("importe").nullable()
}