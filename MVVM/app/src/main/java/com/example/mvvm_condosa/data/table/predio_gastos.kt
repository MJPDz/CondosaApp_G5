package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object GastosTable : IntIdTable("predio_gastos","id_predio_gastos") {
    val idPredio = integer("id_predio").references(PredioTable.id)
    val idPersonal = integer("id_personal").references(PersonalTable.id)
    val periodo = varchar("periodo", length = 8)
    val importe = double("importe")
}