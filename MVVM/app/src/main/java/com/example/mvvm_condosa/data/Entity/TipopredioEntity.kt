package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.TipoPredioTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TipopredioEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TipopredioEntity>(TipoPredioTable)

    var nombre_predio by TipoPredioTable.nombre_predio
}