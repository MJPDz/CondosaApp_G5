package com.example.mvvm_condosa.data.DAO

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import com.example.mvvm_condosa.data.Entity.PredioEntity

class PredioDAO {
    fun obtenerPrediosSinRepetir(): List<Pair<Int, String>> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction PredioEntity.all().distinctBy { it.descripcion }
                    .map { it.id.value to it.descripcion }
            }
        }
    }
}
