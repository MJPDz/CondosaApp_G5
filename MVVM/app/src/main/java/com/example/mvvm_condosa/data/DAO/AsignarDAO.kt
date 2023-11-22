package com.example.mvvm_condosa.data.DAO

import com.example.mvvm_condosa.data.Entity.CajaChicaEntity
import com.example.mvvm_condosa.data.table.CajaChicaTable
import com.example.mvvm_condosa.data.table.GastosTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class AsignarDAO {
    fun sugerencia(idPredio: Int): List<Double> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction GastosTable //Tabla gasto_predio
                    .select { GastosTable.idPredio eq idPredio }
                    .mapNotNull { it[GastosTable.importe] }
            }
        }
    }

    fun calcular(idPredio: Int): Double{
        val suger = sugerencia(idPredio)
        val suma = suger.sum()
        val canti = suger.size
        val promedio = suma / canti
        return "%.2f".format(promedio).toDouble()

    }

    fun updateCaja(idPredio: Int, nuevoMonto: Double) = runBlocking{
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction CajaChicaTable
                    .update({ CajaChicaTable.id_predio eq idPredio }) {
                        it[CajaChicaTable.importe] = nuevoMonto
                    }
            }
        }
    }
}
