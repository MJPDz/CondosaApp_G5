package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.TipoGastoTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TipoGastoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TipoGastoEntity>(TipoGastoTable)

    var id_clase_gasto by TipoGastoTable.id_clase_gasto
    var descripcion by TipoGastoTable.descripcion
}