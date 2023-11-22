package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.GastosTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PredioGastoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PredioGastoEntity>(GastosTable)

    var id_predio by GastosTable.idPredio
    var id_personal by GastosTable.idPersonal
    var periodo by GastosTable.periodo
    var importe by GastosTable.importe
}