package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.GastoTable
import com.example.mvvm_condosa.data.table.PersonalTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PersonalEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PersonalEntity>(PersonalTable)

    var id_persona by PersonalTable.id_persona
    var id_rol by PersonalTable.id_rol
    var fecha_contrato by PersonalTable.fecha_contrato
    var fecha_cese by PersonalTable.fecha_cese
}