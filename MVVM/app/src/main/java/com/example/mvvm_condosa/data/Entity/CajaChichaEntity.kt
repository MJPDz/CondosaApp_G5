package com.example.mvvm_condosa.data.Entity


import com.example.mvvm_condosa.data.table.PredioTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PredioEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PredioEntity>(PredioTable)

    var tipo_predio by TipopredioEntity referencedOn PredioTable.id_tipo_predio
    var descripcion by PredioTable.descripcion
    var ruc by PredioTable.ruc
    var telefono by PredioTable.telefono
    var correo by PredioTable.correo
    var direccion by PredioTable.direccion
}