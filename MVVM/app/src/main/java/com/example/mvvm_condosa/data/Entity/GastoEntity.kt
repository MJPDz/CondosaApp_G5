package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.GastoTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class GastoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GastoEntity>(GastoTable)

    var id_tipo_gasto by GastoTable.id_tipo_gasto
    var descripcion by GastoTable.id_tipo_gasto
}