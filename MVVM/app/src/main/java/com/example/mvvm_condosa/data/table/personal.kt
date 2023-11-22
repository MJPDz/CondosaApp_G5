package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date

object PersonalTable : IntIdTable("personal", "id_personal") {
    val id_persona = integer("id_persona").references(PersonaTable.id)
    val id_rol = integer("id_rol")
    val fecha_contrato = date("fecha_contrato")
    val fecha_cese = date("fecha_cese")
}