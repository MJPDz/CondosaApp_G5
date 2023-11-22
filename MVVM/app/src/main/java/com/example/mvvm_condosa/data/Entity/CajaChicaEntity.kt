package com.example.mvvm_condosa.data.Entity

import com.example.mvvm_condosa.data.table.CajaChicaTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CajaChicaEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CajaChicaEntity>(CajaChicaTable)

    var id_predio by CajaChicaTable.id_predio
    var id_personal by CajaChicaTable.id_personal
    var periodo by CajaChicaTable.periodo
    var importe by CajaChicaTable.importe
    var id_estado by CajaChicaTable.id_estado
    var fecha_registro by CajaChicaTable.fecha_registro
    var casas_nohabitadas by CajaChicaTable.casas_nohabitadas
}