import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvm_condosa.data.Entity.CajaChicaEntity
import com.example.mvvm_condosa.data.Entity.PredioEntity
import com.example.mvvm_condosa.data.table.CajaChicaTable
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegistroDAO {
        fun obtenerImporte(idPredio: Int): List<Double> = runBlocking {
                return@runBlocking withContext(Dispatchers.IO) {
                        transaction {
                                return@transaction CajaChicaTable
                                        .select { CajaChicaTable.id_predio eq idPredio }
                                        .mapNotNull { it[CajaChicaTable.importe] }
                        }
                }
        }

        fun calcularCajachica(idPredio: Int): Double{
                val importe = obtenerImporte(idPredio)
                val caja = importe[0]
                return "%.2f".format(caja).toDouble()
        }
}
