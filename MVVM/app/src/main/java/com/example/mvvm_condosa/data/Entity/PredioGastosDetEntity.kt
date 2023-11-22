package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.GastosDetTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PredioGastosDetEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PredioGastosDetEntity>(GastosDetTable)

    var id_predio_gastos by GastosDetTable.id_predio_gastos
    var id_gasto by GastosDetTable.id_gasto
    var importe by GastosDetTable.importe
}