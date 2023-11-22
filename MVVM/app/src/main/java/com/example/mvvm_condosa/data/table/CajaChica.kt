package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date

object CajaChicaTable : IntIdTable("caja_chica", "id_caja_chica") {
    val id_predio = integer("id_predio").index()
    val id_personal = integer("id_personal")
    val periodo = varchar("periodo", 8)
    val importe = double("importe").nullable()
    val id_estado = integer("id_estado").nullable()
    val fecha_registro = date("fecha_registro").nullable()
    val casas_nohabitadas = short("casas_nohabitadas").nullable()
}
