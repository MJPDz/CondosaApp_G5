import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvm_condosa.data.Entity.CajaChicaEntity
import com.example.mvvm_condosa.data.Entity.ClaseGastoEntity
import com.example.mvvm_condosa.data.Entity.PredioEntity
import com.example.mvvm_condosa.data.Entity.PredioGastoEntity
import com.example.mvvm_condosa.data.Entity.PredioGastosDetEntity
import com.example.mvvm_condosa.data.Entity.TipoGastoEntity
import com.example.mvvm_condosa.data.table.CajaChicaTable
import com.example.mvvm_condosa.data.table.ClaseGastoTable
import com.example.mvvm_condosa.data.table.GastoTable
import com.example.mvvm_condosa.data.table.GastosDetTable
import com.example.mvvm_condosa.data.table.GastosTable
import com.example.mvvm_condosa.data.table.TipoGastoTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.javatime.month
import org.jetbrains.exposed.sql.javatime.year
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegistroDAO {
    fun obtenerImporte(idPredio: Int): List<Pair<Int, Double?>> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
           transaction {
              return@transaction CajaChicaEntity.find { CajaChicaTable.id_predio eq idPredio }
                  .map { it.id.value to it.importe }
           }
        }
    }

    fun obtenerIdClaseGasto(): List<Int> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction ClaseGastoEntity.find { ClaseGastoTable.descripcion eq "Caja Chica" }
                    .map { it.id.value }
            }
        }
    }

    fun obtenerIdTipoGasto(): List<Int> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction TipoGastoEntity.find { TipoGastoTable.id_clase_gasto eq obtenerIdClaseGasto()[0] }
                    .map { it.id.value }
            }
        }
    }

    fun obtenerIdPredioGasto(idPredio: Int): List<Int> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                return@transaction PredioGastoEntity.find { GastosTable.idPredio eq idPredio }
                    .map { it.id.value }
            }
        }
    }

    fun obtenerConsumo(idPredio: Int): List<Double?> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                val idPredioGasto = obtenerIdPredioGasto(idPredio)[0]
                return@transaction PredioGastosDetEntity.find { GastosDetTable.id_predio_gastos eq idPredioGasto }
                    .map { it.importe }
            }
        }
    }

    fun obtenerConsumoConDescripcion(idPredio: Int): List<Pair<Double?, String?>> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            transaction {
                val idPredioGasto = obtenerIdPredioGasto(idPredio)[0]
                return@transaction (GastosDetTable innerJoin GastoTable)
                    .slice(GastosDetTable.importe, GastoTable.descripcion)
                    .select {
                        (GastosDetTable.id_predio_gastos eq idPredioGasto) and
                        (GastoTable.id_tipo_gasto eq 8)
                    }
                    .map { row ->
                        row[GastosDetTable.importe] to row[GastoTable.descripcion]
                    }
            }
        }
    }


    fun calcularConsumo(idPredio: Int): Double {
        //val consumo = obtenerConsumo(idPredio).sumByDouble { it ?: 0.0 }
        val consumo2 = obtenerConsumoConDescripcion(idPredio).sumByDouble { it.first ?: 0.0 }

        return "%.2f".format(consumo2).toDouble()
    }

    fun calcularRestante(idPredio: Int): Double {
        return obtenerCajachica(idPredio) - calcularConsumo(idPredio)
    }

    fun obtenerCajachica(idPredio: Int): Double {
            val importe = obtenerImporte(idPredio)
            val caja = importe.firstOrNull()
            return "%.2f".format(caja?.second).toDouble()
    }

    fun obtenerIdCajachica(idPredio: Int): Int{
            val importe = obtenerImporte(idPredio)
            val caja = importe.firstOrNull()
            return caja?.first ?: 0
    }
}

// predio = 1 id_predio_gastos = 579