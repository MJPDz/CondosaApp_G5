package com.example.mvvm_condosa.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object PersonaTable : IntIdTable("persona", "id_persona") {
    val apellido_paterno = varchar("apellido_paterno", length = 60)
    val apellido_materno = varchar("apellido_materno", length = 60)
    val nombres = varchar("nombres", length = 60)
}