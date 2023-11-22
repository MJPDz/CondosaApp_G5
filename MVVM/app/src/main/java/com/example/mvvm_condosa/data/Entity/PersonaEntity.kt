package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.PersonaTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PersonaEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PersonaEntity>(PersonaTable)

    var apellido_paterno by PersonaTable.apellido_paterno
    var apellido_materno by PersonaTable.apellido_materno
    var nombres by PersonaTable.nombres
}