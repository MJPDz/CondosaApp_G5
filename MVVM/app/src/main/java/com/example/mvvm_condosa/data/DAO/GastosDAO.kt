package com.example.mvvm_condosa.data.DAO

import com.example.mvvm_condosa.data.Entity.PredioGastoEntity
import com.example.mvvm_condosa.data.model.GastosConDetalles
import com.example.mvvm_condosa.data.table.GastoTable
import com.example.mvvm_condosa.data.table.GastosDetTable
import com.example.mvvm_condosa.data.table.GastosTable
import com.example.mvvm_condosa.data.table.PersonaTable
import com.example.mvvm_condosa.data.table.PersonalTable
import com.example.mvvm_condosa.data.table.PredioTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class GastosDAO {
    fun obtenerIdPredioGasto(idPredio: Int): List<Int> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction PredioGastoEntity.find { GastosTable.idPredio eq idPredio }
                    .map { it.id.value }
            }
        }
    }

    fun obtenerGastosConDetalles(idPredio: Int): List<GastosConDetalles> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                val idPredioGasto = obtenerIdPredioGasto(idPredio)[0]

                return@transaction (
                    GastosDetTable innerJoin
                    GastoTable innerJoin
                    GastosTable innerJoin
                    PersonalTable innerJoin
                    PersonaTable innerJoin
                    PredioTable
                )
                .slice(
                    GastosDetTable.id,
                    GastosDetTable.id_predio_gastos,
                    GastosDetTable.id_gasto,
                    GastosDetTable.importe,
                    GastoTable.id_tipo_gasto,
                    GastoTable.descripcion,
                    GastosTable.periodo,
                    GastosTable.idPersonal,
                    PersonalTable.id_persona,
                    PersonaTable.nombres,
                    PredioTable.descripcion
                )
                .select {
                    (GastosDetTable.id_predio_gastos eq idPredioGasto) and
                    (GastoTable.id_tipo_gasto eq 8)
                }
                .map {
                    GastosConDetalles(
                        it[GastosDetTable.id].value,
                        it[GastosDetTable.id_predio_gastos],
                        it[GastosDetTable.id_gasto],
                        it[GastosDetTable.importe],
                        it[GastoTable.id_tipo_gasto],
                        it[GastoTable.descripcion],
                        it[GastosTable.periodo],
                        it[GastosTable.idPersonal],
                        it[PersonalTable.id_persona],
                        it[PersonaTable.nombres],
                        it[PredioTable.descripcion]
                    )
                }
            }
        }
    }



}