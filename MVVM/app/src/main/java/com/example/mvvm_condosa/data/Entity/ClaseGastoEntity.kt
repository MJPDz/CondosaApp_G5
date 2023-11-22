package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.ClaseGastoTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ClaseGastoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ClaseGastoEntity>(ClaseGastoTable)

    var descripcion by ClaseGastoTable.descripcion
}